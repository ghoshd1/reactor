package com.demo.reactor.sec11;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;


public class Lec01SinkOne {

  public static void main(String[] args) {

    Sinks.One<Object> sink = Sinks.one();
    Mono<Object> objectMono = sink.asMono();

    objectMono.subscribe(ReactorUtil.getDefaultSubscriber("Deb"));
   sink.tryEmitValue(1);
  //  sink.tryEmitEmpty();
  //  sink.tryEmitError(new RuntimeException("dummy exception"));


  }

}
