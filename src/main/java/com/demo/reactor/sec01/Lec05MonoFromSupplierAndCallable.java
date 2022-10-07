package com.demo.reactor.sec01;

import com.demo.reactor.utility.ReactorUtil;
import java.util.concurrent.Callable;
import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplierAndCallable {

  public static void main(String[] args) {

    //use just only when you have data
    //Mono<String> stringMono = Mono.just(getName());

    Mono<String> stringMono = Mono.fromSupplier(() -> getName());
 //   stringMono.subscribe(ReactorUtil.onNext());

    System.out.println("############################");
    Callable<String> stringCallable = () -> getName();
    Mono<String> fromCallable = Mono.fromCallable(stringCallable);
    fromCallable.subscribe(ReactorUtil.onNext());

  }

  public static String getName(){
    System.out.println("Generating name");
    return ReactorUtil.faker().name().fullName();
  }
}
