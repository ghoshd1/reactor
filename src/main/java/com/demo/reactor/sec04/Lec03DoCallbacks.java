package com.demo.reactor.sec04;


import com.demo.reactor.utility.ReactorUtil;
import jdk.jshell.execution.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallbacks {

  public static void main(String[] args) {

    Flux.create(fluxSink -> {
      System.out.println("inside create");
      for(int i=1;i<=5;i++){
        fluxSink.next(i);
      }
      fluxSink.complete();
      fluxSink.error(new RuntimeException("demo"));
      System.out.println("--completed");
    })
        .doOnComplete(()-> System.out.println("doOnComplete"))
        .doFirst(() -> System.out.println("doFirst1"))
        .doOnNext(o -> System.out.println("doOnNext"+o))
        .doOnSubscribe(subscription -> System.out.println("doOnSubscribe1 "+subscription))
        .doOnRequest(value -> System.out.println("doOnRequest "+value))
        .doFirst(() -> System.out.println("doFirst2"))
        .doOnError(throwable -> System.out.println("doOnError "+throwable))
        .doOnTerminate(() -> System.out.println("doOnTerminate"))
        .doOnCancel(() -> System.out.println("doOnCancel"))
        .doOnSubscribe(subscription -> System.out.println("doOnSubscribe2 "+subscription))
        .doFinally(signalType -> System.out.println("doFinally"+signalType))
        .doFirst(() -> System.out.println("doFirst3"))
        .doOnDiscard(Object.class,o -> System.out.println("doOnDiscard "+o))
        .take(2)
        .subscribe(ReactorUtil.getDefaultSubscriber());

  }

}
