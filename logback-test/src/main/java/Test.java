import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by siyunfei on 2018/11/12.
 */
public class Test {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Test.class);
        logger.debug("hello");
        Logger logger1 = LoggerFactory.getLogger("com.iqiyi.rover.commons.RoverSpanLoggerReporter");
        logger1.info("dfadfadfadf");
    }
}
