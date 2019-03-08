import com.sun.xml.internal.bind.v2.TODO;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
/*

        Observable<String> mystrings = Observable.just("alpa", "beta", "gema", "delta", "epilosion");
        mystrings.subscribe(s -> {
            System.out.println(s);
        });

        mystrings.map(s -> s.length()).subscribe(s -> System.out.println(s));
*/


       /* Observable<Long> second = Observable.interval(1, TimeUnit.SECONDS);
        second.subscribe(s -> System.out.println(s));
        sleept(5000);
    }

    public static void sleept(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Observable<String> source = Observable.create(emiter -> {
            try {

                emiter.onNext("alpha");
                emiter.onNext("betha");
                emiter.onNext("gamma");
                emiter.onNext("delta");
                emiter.onNext("epsilon");
            } catch (Throwable throwable) {
                emiter.onError(throwable);
            }
        });

        source.subscribe(s -> System.out.println("REceived:" + s), Throwable::printStackTrace);

        Observable<String> source = Observable.create(emiter -> {
            try {
                emiter.onNext("alpha");
                emiter.onNext("betha");
                emiter.onNext("gamma");
                emiter.onNext("delta");
                emiter.onNext("epsilon");
            } catch (Throwable throwable) {
                emiter.onError(throwable);
            }
        });
        source.map(String::length)
                .filter(i -> i >= 5)
                .subscribe(s -> System.out.println("RECEIVED: " + s));


        Observable<String> source = Observable.just("alpha", "betha", "gamma", "delta", "epsilon");
        source.map(String::length).filter(i -> i >= 5)
                .subscribe(s -> System.out.println("RECEIVED " + s));



       //ubah list menjadi observable
        List<String> items = Arrays.asList();

        Observable<String> source = Observable.fromIterable(items);
        source.map(String::length).filter(i -> i >= 5)
                 .subscribe(s -> System.out.println("RECEIVED " + s));
   */


        Observable<String> sourvce = Observable.just("alpha", "betha", "gamma", "delta", "epsilon");

        //versi panjang
        Observer<Integer> myObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("RECEIVED: " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                println("done");
            }
        };
        sourvce.map(String::length).filter(i -> i >= 5)
                //.subscribe(myObserver); //versi panjang
                .subscribe(i -> println("RECEIVED: " + i),
                        Throwable::printStackTrace,
                        () -> println("Done!")); //versi pendek
                        //lamba oncomplete bisa nggak dipake
















    }

    public static void println(Object l) {
        System.out.println(l);
    }
}
