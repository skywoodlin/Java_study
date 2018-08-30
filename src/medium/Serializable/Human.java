package medium.Serializable;

import java.io.Serializable;

/**
 * Created by xjlin on 2018/8/23.
 */
class Human extends Living implements Serializable{
    /**
     *
     */
//    private static final long serialVersionUID = -4389621464687273122L;
    private static final long serialVersionUID = -33L;
    private String id;
    private String name;
//    private double weight;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
/*
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
*/

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    @Override
    public String toString() {
//        return getEnvironment() + " : " + name + ", " + weight;
//        return getEnvironment() + " : " + id + ", " + name + ", " + weight;
        return getEnvironment() + " : " + name;
    }
}
