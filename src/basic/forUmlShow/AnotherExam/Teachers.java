package basic.forUmlShow.AnotherExam;

/**
 * Created by xjlin on 2019/1/29.
 */
public class Teachers extends Person{
    /**
     * @pdOid 55b38630-1e30-449b-9cb7-f8ef9de59412
     */
    private int tNumber;
    private Address address;
    private Car car;
    private Finger finger;

    /**
     * @pdOid f603d47d-a51f-4b0c-b10b-881842374f8a
     */
    public String teach(){
        // TODO: implement
        return "I am teaching";
    }

    public int gettNumber(){
        return tNumber;
    }

    public void settNumber(int tNumber){
        this.tNumber = tNumber;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    public Car getCar(){
        return car;
    }

    public void setCar(Car car){
        this.car = car;
    }

    public Finger getFinger(){
        return finger;
    }

    public void setFinger(Finger finger){
        this.finger = finger;
    }
}

