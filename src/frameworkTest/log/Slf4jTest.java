package frameworkTest.log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xjlin on 2017/6/4.
 */
public class Slf4jTest {
    private static final Logger logger = LoggerFactory.getLogger(Slf4jTest.class);
    public static void test() {
        logger.debug("testInfo");
    }
    public static void main(String[] args)
    {
        logger.info("Hello {}","SLF4J");
        logger.debug("Hello {}","SLF4J");
        logger.error("Hello {}","SLF4J");

        Slf4jTest.test();

    }


}
