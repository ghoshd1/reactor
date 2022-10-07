package com.demo.reactor.sec01;

import com.demo.reactor.utility.ReactorUtil;
import java.util.concurrent.CompletableFuture;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

  public static void main(String[] args) {

    Mono.fromRunnable(timeConsumingProcess())
        .subscribe(ReactorUtil.onNext(), ReactorUtil.onError(), ReactorUtil.onComplete());

    Mono.fromRunnable(timeConsumingProcess())
        .subscribe(ReactorUtil.onNext(), ReactorUtil.onError(), () -> {
          System.out.println("Send Notifications");
        });

  }

  public static Runnable timeConsumingProcess() {
    System.out.println("Entered timeConsumingProcess method");
    return () -> {
      ReactorUtil.sleepSeconds(5);
      System.out.println("Operation completed...");
    };
  }
}
