package homework.day13.num1;

/**
 * Created by xjlin on 2018/9/3.
 */
public class Retangle implements Shape{
    private double longth;
    private double width;

    Retangle(double longth, double width) {
        this.longth = longth;
        this.width = width;
    }
    @Override
    public double countAera() throws Exception{
        if(longth <= 0 || width <= 0) {
            throw new Exception("长宽数据不对！");
        }
        return longth * width;
    }
}
