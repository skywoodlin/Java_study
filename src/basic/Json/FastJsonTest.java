package basic.Json;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by xjlin on 2018/5/10.
 */
public class FastJsonTest {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", true);
        jsonObject.put("a", false);
        System.out.println(jsonObject.toString());
    }

}
