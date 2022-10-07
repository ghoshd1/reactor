package com.demo.reactor.utility;

import com.github.javafaker.Faker;
import java.util.function.Consumer;
import org.reactivestreams.Subscriber;

public class ReactorUtil {

  private static final Faker FAKER = Faker.instance();
  public static Consumer<Object> onNext() {
    return item -> System.out.println("Received " + item);
  }

  public static Consumer<Throwable> onError() {
    return error -> System.out.println("Exception Happened " + error.getMessage());
  }

  public static Runnable onComplete() {
    return () -> System.out.println("Completed");
  }

  public static Faker faker(){
    return FAKER;
  }

  public static void sleepSeconds(int seconds){
    try {
      Thread.sleep(seconds*1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static Consumer<Object> onNext(String receiverName) {
    return item -> System.out.println("Received by " +receiverName+" "+ item);
  }

  public static Subscriber<Object> getDefaultSubscriber(){
    return  new CustomSubscriber();
  }

  public static Subscriber<Object> getDefaultSubscriber(String name){
    return  new CustomSubscriber(name);
  }
}
