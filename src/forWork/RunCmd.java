package forWork;

/**
 * Created by xjlin on 2017/1/18.
 */
public class RunCmd {
    public void execCommand(String[] arstringCommand) {
        for (int i = 0; i < arstringCommand.length; i++) {
            System.out.print(arstringCommand[i] + " ");
        }
        try {
            Runtime.getRuntime().exec(arstringCommand);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void execCommand(String arstringCommand) {
        try {
            Runtime.getRuntime().exec("cmd.exe /C start /b D:\\wamp64\\tomcat7_64\\bin\\startup.bat");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cmd(){
        /*//打开记算器
        String[] arstringCommand = new String[] {
                "cmd ",
                "/k",
                "start", // cmd Shell命令
                "calc"
        };
        execCommand(arstringCommand);
        //打开记事本
        String cmd = "cmd /k start notepad";*/
        String cmd = "cmd.exe /C start /b D:\\wamp64\\tomcat7_64\\bin\\startup.bat";
        execCommand(cmd);
    }

    public static void main(String[] args){
        new RunCmd().cmd();
    }
}
