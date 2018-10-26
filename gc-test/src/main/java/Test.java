import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by siyunfei on 2018/10/23.
 */
public class Test {
    public static void main(String[] args) {
        while (true) {
            request();
        }
    }

    //
    public static void request() {
        long start = System.currentTimeMillis();
        try {
            Map<String, byte[]> map = new HashMap<String, byte[]>();
            Thread.sleep(20);
            map.put("hello", new byte[1024 * 1024]);
            if (map.size() == 10000) {
                map.clear();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("cost:" + (System.currentTimeMillis() - start) + ", date:" + new Date());
    }


}
