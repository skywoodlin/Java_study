package forWork.com.xjlin.ognl.test;

import forWork.com.xjlin.ognl.domain.SlDept;
import forWork.com.xjlin.ognl.domain.SlEmployee;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * Created by xjlin on 2017/8/11.
 下面，相信通过上面的例子，我们对Ognl表达式有了一个认识，下面开始学习如何在Ognl表达式用调用方法，
 大家都知道方法分为静态方法和非静态方法，好的，看例子：
 */
public class OgnlTest3 {

    public static void main(String[] args) throws OgnlException {
        // 新建一个部门对象并设置部门名称
        SlDept dept = new SlDept();
        dept.setName("上海-软件技术支持部");

        // 新建一个员工对象并设置员工姓名
        SlEmployee emp = new SlEmployee();
        emp.setName("李小龙");
        emp.setSlDept(dept);
        emp.setAge("22");
        // 构建一个OgnlContext对象
        OgnlContext context = new OgnlContext();

        // 将上述部门和员工对象放入Ognl上下文环境中
        context.put("dept", dept);
        context.put("emp", emp);

        // 将员工设置为跟对象
        context.setRoot(emp);

        // 从根对象中直接获取部门名称长度，非静态方法
        Object expression = Ognl.parseExpression("slDept.name.length()");
        Object length = Ognl.getValue(expression, context, context.getRoot());
        System.out.println(length);

        // 在Ognl表达式中使用静态方法
        expression = Ognl.parseExpression("@java.lang.Integer@valueOf(age)");
        length = Ognl.getValue(expression, context, context.getRoot());
        System.out.println(length);

    }

}