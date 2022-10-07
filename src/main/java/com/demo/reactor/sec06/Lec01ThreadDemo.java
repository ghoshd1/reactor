package com.demo.reactor.sec06;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec01ThreadDemo {

  public static void main(String[] args) {

    Flux.create(fluxSink -> {
      printThreadName("create");
      fluxSink.next(1);
    })
        .doOnNext(o -> printThreadName("doOnNext "+o))
        .subscribe(ReactorUtil.getDefaultSubscriber("Deb"));
  }

  public static void printThreadName(String message){
    System.out.println(message+"\t\t[Thread Name-"+Thread.currentThread().getName()+"]");
  }
}
