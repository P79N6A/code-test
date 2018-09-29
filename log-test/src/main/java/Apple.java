import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Apple {

    private static final Logger logger = LoggerFactory.getLogger(Apple.class);

    private int num;

    @Override
    public String toString() {
        return "Apple{" +
                "num=" + num +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Apple(int num){
        this.num = num;
        logger.debug("this is an apple, number:{}", num);
    }
}
