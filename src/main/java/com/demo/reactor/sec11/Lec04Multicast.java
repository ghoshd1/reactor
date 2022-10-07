package com.demo.reactor.sec11;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;


public class Lec04Multicast {

  public static void main(String[] args) {

    Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();
    Flux<Object> fluxSink = sink.asFlux();

    fluxSink.subscribe(ReactorUtil.getDefaultSubscriber("Deb"));
    fluxSink.subscribe(ReactorUtil.getDefaultSubscriber("Deb1"));
    sink.tryEmitNext(1);
    sink.tryEmitNext(2);
    sink.tryEmitComplete();

  }

}
