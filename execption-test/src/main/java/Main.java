/**
 * Created by siyunfei on 2018/10/25.
 */
public class Main {
    public static void main(String[] args) {
        try {
            f();
            print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void f() throws Exception {
        int a = 4 / 0;
    }
    public static void print() {
        System.out.println("========");
    }
}
