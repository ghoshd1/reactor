package com.demo.reactor.sec11;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import java.util.Queue;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;
import reactor.util.concurrent.Queues;


public class Lec05MulticastDirectAllOrNothing {

  public static void main(String[] args) {

    System.setProperty("reactor.bufferSize.small", "16");
    Many<Object> sink = Sinks.many().multicast().directAllOrNothing();
    Flux<Object> fluxSink = sink.asFlux();


    fluxSink.subscribe(ReactorUtil.getDefaultSubscriber("Deb"));
    fluxSink.delayElements(Duration.ofMillis(200)).subscribe(ReactorUtil.getDefaultSubscriber("Sam"));

    for(int i=0;i<100;i++){
      sink.tryEmitNext(i);
    }

    sink.tryEmitComplete();

    ReactorUtil.sleepSeconds(100);
  }

}
