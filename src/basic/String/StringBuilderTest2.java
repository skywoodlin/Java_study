package basic.String;

/**
 * Created by xjlin on 2017/6/23.
 */
public class StringBuilderTest2{
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("1%;");
        sb.append("2%;");
        sb.append("3%;");
        sb.append("4%;");

        //删除最后一个分号
        int strlength = sb.length();
        sb.deleteCharAt(strlength-1);

        System.out.println(sb.toString());
    }


}
