package com.demo.reactor.sec03;

import com.demo.reactor.utility.ReactorUtil;
import java.util.function.Consumer;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

  public static void main(String[] args) {
    Flux.create(fluxSink -> {
      fluxSink.next(1);
      fluxSink.next(2);
      fluxSink.complete();
    })
        .subscribe( ReactorUtil.getDefaultSubscriber());


    Flux.create(fluxSink -> {
      String country = "";
      do{
        country= ReactorUtil.faker().country().name();
        fluxSink.next(country);
      }while (!country.toLowerCase().equals("canada"));

      fluxSink.complete();
    })
        .subscribe(ReactorUtil.getDefaultSubscriber("country-"));
  }
}
