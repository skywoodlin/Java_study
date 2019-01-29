package basic.forUmlShow.AnotherExam;

/**
 * Created by xjlin on 2019/1/29.
 */
public class Students extends Person {
    /** @pdOid 0c7627fd-fa78-4f60-a859-2b90274323e1 */
    private int sNumber;
    private Address address;
    private Course course;

    /** @pdOid 1f929347-b84a-4a54-9ca9-144de66c742b */
    public String study() {
        // TODO: implement
        return "I am learning";
    }

    public int moveSpeed(Bicycle bicycle) {
        return bicycle.travelSpeed();
    }

    public int getsNumber(){
        return sNumber;
    }

    public void setsNumber(int sNumber){
        this.sNumber = sNumber;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    public Course getCourse(){
        return course;
    }

    public void setCourse(Course course){
        this.course = course;
    }
}
