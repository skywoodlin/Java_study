package medium.Serializable;

import java.io.Serializable;

/**
 * Created by xjlin on 2018/8/23.
 */
public class Living implements Serializable{  //
    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
