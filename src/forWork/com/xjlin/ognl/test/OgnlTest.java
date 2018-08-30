package forWork.com.xjlin.ognl.test;

import forWork.com.xjlin.ognl.domain.SlDept;
import forWork.com.xjlin.ognl.domain.SlEmployee;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjlin on 2017/8/11.
 */


public class OgnlTest {

    public static void main(String[] args) throws OgnlException {
        // 新建一个部门对象并设置部门名称
        SlDept dept = new SlDept();
        dept.setName("销售部");

        // 新建一个员工对象并设置员工姓名
        SlEmployee emp = new SlEmployee();
        emp.setName("张三");

        // 构建一个OgnlContext对象
        OgnlContext context = new OgnlContext();

        // 将上述部门和员工对象放入Ognl上下文环境中
        context.put("dept", dept);
        context.put("emp", emp);

        // 将员工设置为根对象
        context.setRoot(emp);

        // 构建Ognl表达式的树状表示,用来获取
        Object expression = Ognl.parseExpression("#dept.name");

        // 解析树状表达式，返回结果
        Object deptName = Ognl.getValue(expression, context, context.getRoot());

        System.out.println(deptName);


        List<SlEmployee> employeeList = new ArrayList<>();
        // 新建一个员工对象并设置员工姓名
        for(int i = 0; i < 10; i++) {
            SlEmployee empTmp = new SlEmployee();
            empTmp.setName("张三" + i);
            employeeList.add(empTmp);
        }

        dept.setSlEmployeeList(employeeList);

        // 构建Ognl表达式的树状表示,用来获取
        Object expression2 = Ognl.parseExpression("#dept.slEmployeeList.isEmpty()");

        // 解析树状表达式，返回结果
        Object employeeList2 = Ognl.getValue(expression2, context, context.getRoot());

        System.out.println(employeeList2);   //false

    }

}