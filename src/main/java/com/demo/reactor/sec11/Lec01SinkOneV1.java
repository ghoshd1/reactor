package com.demo.reactor.sec11;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;


public class Lec01SinkOneV1 {

  public static void main(String[] args) {

    Sinks.One<Object> sink = Sinks.one();
    Mono<Object> objectMono = sink.asMono();

    objectMono.subscribe(ReactorUtil.getDefaultSubscriber("Deb"));


    sink.emitValue(1,(signalType, emitResult) -> {
      System.out.println(signalType.name());
      System.out.println(emitResult.name());
      return false;
    });

    sink.emitValue(2,(signalType, emitResult) -> {
      System.out.println("signalType->"+signalType.name());
      System.out.println("emitResult->"+emitResult.name());
      return false;
    });
  }

}
