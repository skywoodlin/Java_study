package forWork.com.xjlin.ognl.domain;

/**
 * Created by xjlin on 2017/8/11.
 */
public class SlEmployee implements java.io.Serializable {

    private static final long serialVersionUID = 4873217019660076767L;

    private SlDept slDept;

    private String name;

    private String age;

    public SlEmployee() {
    }

    public SlDept getSlDept() {
        return slDept;
    }

    public void setSlDept(SlDept slDept) {
        this.slDept = slDept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
