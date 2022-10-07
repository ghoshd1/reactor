package com.demo.reactor.sec03.helper;

import com.demo.reactor.utility.ReactorUtil;
import java.util.function.Consumer;
import reactor.core.publisher.FluxSink;

public class NameProducer implements Consumer<FluxSink> {

  private FluxSink<String> fluxSink;

  @Override
  public void accept(FluxSink fluxSink) {
    this.fluxSink = fluxSink;
  }

  public void produce(){
    String country = ReactorUtil.faker().country().name();
    fluxSink.next(Thread.currentThread().getName()+"-"+country);
  }

  public void close(){
    fluxSink.complete();
  }
}
