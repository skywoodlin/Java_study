package frameworkTest.log;
import org.apache.log4j.*;
/**
 * log4j.properties简单配置样例说明
 * Created by xjlin
 * 1. 如果没有显式设置配置文件， 默认到工程src根目录下去查找log4j文件， 否则按照显式配置的来。
 *  PropertyConfigurator.configure( "D:\\project_study\\Java_study\\src\\basic\\log\\log4j.properties" );
 * 2. 配置文件中的每个记录器， 只要级别达到了， 就会写入， 所以有可能写入多个日志文件
 * log4j.rootLogger = debug,stdout,D,E,F
 *
 */
public class UseLog4j_5 {
    //日志记录器
    private static Logger LOGGER = LogManager.getLogger(UseLog4j.class);
    //程序入口——主函数
    public static void main(String[]args) {
        //读取使用Java的特性文件编写的配置文件
//        PropertyConfigurator.configure( "D:\\project_study\\Java_study\\src\\frameworkTest\\log\\log4j.properties" );
        //输出日志信息，测试日志级别的作用（配置在配置文件中），仅仅输出大于等于目前有效级别的日志信息
        LOGGER.debug("[1]-my level is DEBUG Godtrue 说：今天天气很好呀！");
        LOGGER.info("[2]-my level is INFO");
        LOGGER.warn("[3]-my level is WARN");
        LOGGER.error("[4]-my level is ERROR");
    }
}