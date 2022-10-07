package com.demo.reactor.sec03;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {

  public static void main(String[] args) {

/*
    Flux.create(fluxSink -> {
          String country = "";
          do{
            country= ReactorUtil.faker().country().name();
            System.out.println("emitting "+country);
            fluxSink.next(country);
          }while (!country.toLowerCase().equals("canada"));

          fluxSink.complete();
        })
        .take(2)
        .subscribe(ReactorUtil.getDefaultSubscriber("country-"));*/




    Flux.create(fluxSink -> {
          String country = "";
          do{
            country= ReactorUtil.faker().country().name();
            System.out.println("emitting "+country);
            fluxSink.next(country);
          }while (!country.toLowerCase().equals("canada")&&!fluxSink.isCancelled());

          fluxSink.complete();
        })
        .take(2)
        .subscribe(ReactorUtil.getDefaultSubscriber("country-"));


  }

}
