package com.demo.reactor.sec06;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec01ThreadDemoV1 {

  public static void main(String[] args) {

    Flux<Object> flux = Flux.create(fluxSink -> {
          printThreadName("create");
          fluxSink.next(1);
        })
        .doOnNext(o -> printThreadName("doOnNext " + o));

    Runnable r = ()-> {
      flux.subscribe(ReactorUtil.getDefaultSubscriber("Sub1"));
    };

    for(int i=0;i<5;i++){
      new Thread(r).start();
    }
  }



  public static void printThreadName(String message){
    System.out.println(message+"\t\t[Thread Name-"+Thread.currentThread().getName()+"]");
  }
}
