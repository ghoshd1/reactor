package com.demo.reactor.sec11;

import com.demo.reactor.utility.ReactorUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;


public class Lec03SinkThreadSafety {

  static List<Object> integerList = new ArrayList<>();

  public static void main(String[] args) {

    Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();
    Flux<Object> fluxSink = sink.asFlux();

    fluxSink.subscribe(integerList::add);

  /* for(int i=1;i<1000;i++){
     final  int j=i;
     CompletableFuture.runAsync(()->sink.tryEmitNext(j));
   }*/

    for(int i=1;i<=1000;i++){
      final  int j=i;
      CompletableFuture.runAsync(()->sink.emitNext(j,(signalType, emitResult) -> {
        return true;
      }));
    }

   ReactorUtil.sleepSeconds(5);

    System.out.println(integerList.size());
  }

}
