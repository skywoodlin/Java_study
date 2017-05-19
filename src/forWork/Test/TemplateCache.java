package forWork.Test;

import java.util.HashMap;
import java.util.Map;
import com.google.common.collect.Maps;

/**
 * Created by xjlin on 2017/3/17.
 */
public class TemplateCache {

    private static TemplateCache cache = new TemplateCache();

    /**
     * <应用代码,<模板名,模板内容>>
     */
    private Map<String,Map<String,String>> templates = Maps.newHashMap();


    private TemplateCache() {
        for (ThirdAppEnum thirdAppEnum : ThirdAppEnum.values()) {
            this.templates.put(thirdAppEnum.getCode(), new HashMap<String,String>());
        }
    }

    public static TemplateCache getInstance() {
        return cache;
    }

    /**
     * 获取模板内容
     * @param appCode
     * @param templateName
     * @return
     */
    public String getTemplateContext(String appCode,String templateName) {
        Map<String,String> data = this.templates.get(appCode);
        if(!data.containsKey(templateName)) {
            return null;
        }
        return data.get(templateName);
    }

    /**
     * 保存模板
     * @param appCode
     * @param templateName
     * @param context
     */
    public void put(String appCode,String templateName,String context) {
        Map<String,String> data = this.templates.get(appCode);
        data.put(templateName,context);
    }

    public static void main(String[] args) {
        TemplateCache templateCache = TemplateCache.getInstance();
        System.out.println("haha");
    }

}
