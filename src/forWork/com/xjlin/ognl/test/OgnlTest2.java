package forWork.com.xjlin.ognl.test;

import forWork.com.xjlin.ognl.domain.SlDept;
import forWork.com.xjlin.ognl.domain.SlEmployee;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * Created by xjlin on 2017/8/11.
 * 获取根对象的属性值的方式，有两种，第一种也是跟上述方式一样，不多做叙述
 * 第二种，直接写属性名称就可以，注意：这个时候就不要加“#”，如下
 *
 * 原理是这样的，如果Ognl在解析表达式的时候发现表达式开头带有"#"，会去普通对象中，去寻找，如果没有"#"，
 * 则会默认去根对象中去寻找，由于根对象只有一个，所以只需要属性名字
 */
public class OgnlTest2 {

    public static void main(String[] args) throws OgnlException {
        // 新建一个部门对象并设置部门名称
        SlDept dept = new SlDept();
        dept.setName("软件开发部");

        // 新建一个员工对象并设置员工姓名
        SlEmployee emp = new SlEmployee();
        emp.setName("李四");
        emp.setSlDept(dept);

        // 构建一个OgnlContext对象
        OgnlContext context = new OgnlContext();

        // 将上述部门和员工对象放入Ognl上下文环境中
        context.put("dept", dept);
        context.put("emp", emp);

        // 将员工设置为跟对象
        context.setRoot(emp);

        // 从普通对象中直接获取部门名称
        Object expression = Ognl.parseExpression("#dept.name");
        Object deptName = Ognl.getValue(expression, context, context.getRoot());
        System.out.println(deptName);
        System.out.println("-------------------------------------------");
        // 间接获取部门名称
        expression = Ognl.parseExpression("#emp.slDept.name");
        deptName = Ognl.getValue(expression, context, context.getRoot());
        System.out.println(deptName);
        System.out.println("-------------------------------------------");
        // 从根对象中直接获取部门名称
        expression = Ognl.parseExpression("slDept.name");
        deptName = Ognl.getValue(expression, context, context.getRoot());
        System.out.println(deptName);
    }

}