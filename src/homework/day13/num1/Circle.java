package homework.day13.num1;

/**
 * Created by xjlin on 2018/9/3.
 */
public class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double countAera() throws Exception{
        if(radius < 0) {
            throw new Exception("直径错误");
        }
        return radius * radius;
    }
}
