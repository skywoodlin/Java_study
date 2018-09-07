package homework.day13.num1;

/**
 * Created by xjlin on 2018/9/3.
 */
public class ShapeTest{
    public static void main(String[] args) throws Exception{
        Shape circle = new Circle(3.3);
        System.out.println(circle.countAera());

        Shape retangle = new Retangle(0,8);
        System.out.println(retangle.countAera());
    }


}
