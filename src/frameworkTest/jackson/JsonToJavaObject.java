package frameworkTest.jackson;

import Vo.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by xjlin on 2017/6/5.
 */
public class JsonToJavaObject {
    public static void main(String[] args) throws ParseException, IOException {
        String json = "{\"name\":\"zhangsan\",\"age\":20,\"birthday\":844099200000,\"email\":\"zhangsan@163.com\"}";
        /**
         * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
         */
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(json, User.class);
        System.out.println(user);
    }
}
