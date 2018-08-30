package forWork.com.xjlin.ognl.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SlDept implements java.io.Serializable {

    private static final long serialVersionUID = 3537237434024057830L;

    private String name;

    private Set<SlEmployee> slEmployees = new HashSet<SlEmployee>(0);

    private List<SlEmployee> slEmployeeList;

    public SlDept() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SlEmployee> getSlEmployees() {
        return slEmployees;
    }

    public void setSlEmployees(Set<SlEmployee> slEmployees) {
        this.slEmployees = slEmployees;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<SlEmployee> getSlEmployeeList() {
        return slEmployeeList;
    }

    public void setSlEmployeeList(List<SlEmployee> slEmployeeList) {
        this.slEmployeeList = slEmployeeList;
    }
}