package com.demo.reactor.sec11;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;


public class Lec06Replay {

  public static void main(String[] args) {

    System.setProperty("reactor.bufferSize.small", "16");
    Many<Object> sink = Sinks.many().replay().all();
    Flux<Object> fluxSink = sink.asFlux();

    sink.tryEmitNext("hi");
    sink.tryEmitNext("hello");

    fluxSink.subscribe(ReactorUtil.getDefaultSubscriber("Deb"));
    fluxSink.delayElements(Duration.ofMillis(200)).subscribe(ReactorUtil.getDefaultSubscriber("Sam"));

    for(int i=0;i<100;i++){
      sink.tryEmitNext(i);
    }

    sink.tryEmitComplete();

    ReactorUtil.sleepSeconds(100);
  }

}
