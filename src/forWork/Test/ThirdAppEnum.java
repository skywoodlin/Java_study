package forWork.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第三方应用代码
 * Created by linxw on 2016/7/8.
 */
public enum ThirdAppEnum {

    NC("nc", "用友NC产品", "8087"),
    U8("u8", "用友U8产品", "80"),
    EAS("eas", "金蝶EAS产品", "6888"),
    K3("k3", "金蝶K3产品", "80"),
    SAP("sap", "SAP产品", "80");

    private static List<Map<String, Object>> list = new ArrayList<>();

    /**
     * 系统代码
     */
    private String code;

    /**
     * 系统名称
     */
    private String name;

    /**
     * 系统自带接口的端口
     */
    private String port;

    private ThirdAppEnum(String code, String name, String port) {
        this.code = code;
        this.name = name;
        this.port = port;
    }

    /**
     * 通过code获取枚举
     * @param code
     * @return
     */
    public static ThirdAppEnum getByCode(String code) {
        ThirdAppEnum e = null;
        for (ThirdAppEnum thirdAppEnum : ThirdAppEnum.values()) {
            if(thirdAppEnum.getCode().equals(code)) {
                e = thirdAppEnum;
                break;
            }
        }
        return e;
    }


    /**
     * 转换成List<Map>
     * JOSN类似：[{code:1,name:"名称1"},{code:2,name:"名称2"},{code:3,name:"名称3"}...]
     */
    public static List<Map<String, Object>> toList() {
        if (list.isEmpty()) {
            Map<String, Object> vmap = null;
            for (ThirdAppEnum enumerate : ThirdAppEnum.values()) {
                vmap = new HashMap<>();
                vmap.put("name", enumerate.getName());
                vmap.put("code", enumerate.getCode());
                list.add(vmap);
            }
        }
        return list;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}

