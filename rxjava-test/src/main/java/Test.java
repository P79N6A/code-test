import rx.Observable;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author siyunfei
 * 2018/10/20 8:40 PM
 */
public class Test {
    public static void main(String[] args) {
        Observable.just("hello", "world").map(s -> s + ":56").subscribe(s -> System.out.println(s + "===="));

        Observable.from(new ArrayList<>(Arrays.asList("abc", "def"))).subscribe(s -> System.out.println(s));

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello world");
                subscriber.onCompleted();
            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("completed");
                int a = 0;
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        observable.subscribe(subscriber);
    }
}
