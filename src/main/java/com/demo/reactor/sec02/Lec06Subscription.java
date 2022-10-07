package com.demo.reactor.sec02;

import com.demo.reactor.utility.CustomSubscriber;
import com.demo.reactor.utility.ReactorUtil;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class Lec06Subscription {

  public static void main(String[] args) {
    AtomicReference<Subscription> subscription = new AtomicReference<>();

    Flux.range(3,10)
        .log()
        .subscribeWith(new Subscriber<Integer>() {
          @Override
          public void onSubscribe(Subscription s) {
            System.out.println("onSubscribe invoked");
            subscription.set(s);
          }

          @Override
          public void onNext(Integer integer) {
            System.out.println("onNext invoked"+integer);
          }

          @Override
          public void onError(Throwable t) {
            System.out.println("onError invoked");
          }

          @Override
          public void onComplete() {
            System.out.println("onComplete invoked");
          }
        });

    subscription.get().request(3);
    ReactorUtil.sleepSeconds(5);

    subscription.get().request(3);
    ReactorUtil.sleepSeconds(5);

    subscription.get().cancel();
    subscription.get().request(3);


   // Flux.range(3,10).subscribeWith(ReactorUtil.getDefaultSubscriber());

}}
