import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        printT();
        Apple apple = new Apple(4);
    }

    public static void printT() {
        System.out.println("Hello");
        logger.info("==============print hello============");
    }
}
