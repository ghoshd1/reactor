package com.demo.reactor.sec03;

import com.demo.reactor.sec03.helper.NameProducer;
import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactoring {

  public static void main(String[] args) {

   NameProducer fluxSink = new NameProducer();

   Flux.create(fluxSink)
        .subscribe(ReactorUtil.getDefaultSubscriber("country-"));

   fluxSink.produce();


   //Its thread safe
   Runnable r = fluxSink::produce;

   for (int i=1;i<10;i++){
     new Thread(r).start();
   }

   ReactorUtil.sleepSeconds(2);

     fluxSink.close();
  }
}
