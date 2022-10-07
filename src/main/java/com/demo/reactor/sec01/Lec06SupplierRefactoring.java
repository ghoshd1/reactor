package com.demo.reactor.sec01;

import com.demo.reactor.utility.ReactorUtil;
import java.util.concurrent.Callable;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

  public static void main(String[] args) {

    getName();
    getName();
    getName();
  // getName().subscribe(ReactorUtil.onNext());

  /*  getName()
        .subscribeOn(Schedulers.boundedElastic())
        .subscribe(ReactorUtil.onNext());*/

   /* String name = getName().subscribeOn(Schedulers.boundedElastic()).block();
    System.out.println(name);*/
    getName();

   ReactorUtil.sleepSeconds(10);

  }

  public static Mono<String> getName() {
    System.out.println("Entered getName method");
    return Mono.fromSupplier(() -> {
      System.out.println("Generating name ....");
      ReactorUtil.sleepSeconds(3);
      return ReactorUtil.faker().name().fullName();
    }).map(String::toUpperCase);
  }
}
