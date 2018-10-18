import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by siyunfei on 2018/10/12.
 */
public class Test {
    static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        /*list.add("hello");
        list.add("world");
        list.forEach(System.out::println);
        Map<String, Integer> map = new HashMap<>();
        map.put("hello", 1);
        map.put("world", 2);
        map.forEach((key, value) -> System.out.println(key + value));*/
        list.forEach((p) -> list.add("fdf"));
        list.forEach(System.out::println);
    }

    public static void sout(Consumer<String> action, String string) {
        list.forEach(action);
    }
}

@FunctionalInterface
interface Executor {
    void execute();
}