import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by siyunfei on 2018/10/18.
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000000; i++) {
            sb.append(random.nextInt() + " ");
        }
        testSplit(sb.toString());
        testStringTokenzier(sb.toString());
    }

    private static void testSplit(String str) {
        long start = System.nanoTime();
        String[] strings = str.split(" ");
        /*StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string);
        }*/
        System.out.println(System.nanoTime() - start);
    }

    private static void testStringTokenzier(String str) {
        long start = System.nanoTime();
        StringTokenizer st = new StringTokenizer(str);
        /*StringBuilder result = new StringBuilder();
        while (st.hasMoreTokens()) {
            result.append(st.nextToken());
        }*/
        System.out.println(System.nanoTime() - start);
    }
}
