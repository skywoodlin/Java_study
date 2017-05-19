package medium.ClassInitialize;

/**
 * Created by xjlin on 2017/1/3.
 */
public class LoadClass {
    private static LoadClass LoadClasser = new LoadClass(); //step 1  
    private static int count1;               //step 2  
    private static int count2 = 2;           //step 3  
    public LoadClass(){                           //step 4  
        count1++;
        count2++;
        System.out.println("" + count1 + count2);
    }
    public static LoadClass getLoadClasser(){          //step 5  
        return LoadClasser;
    }

    public static void main(String[] args){
        LoadClass.getLoadClasser();
    }
}
