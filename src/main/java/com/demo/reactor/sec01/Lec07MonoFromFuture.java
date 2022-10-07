package com.demo.reactor.sec01;

import com.demo.reactor.utility.ReactorUtil;
import java.util.concurrent.CompletableFuture;
import reactor.core.publisher.Mono;

public class Lec07MonoFromFuture {

  public static void main(String[] args) {

    Mono.fromFuture(getName()).subscribe(ReactorUtil.onNext());

    ReactorUtil.sleepSeconds(6);
  }

  public static CompletableFuture<String> getName() {
    System.out.println("Entered getName method");
    return CompletableFuture.supplyAsync(()->{
      ReactorUtil.sleepSeconds(5);
      System.out.println("Generating name...");
      return ReactorUtil.faker().name().fullName();
    });
  }
}
