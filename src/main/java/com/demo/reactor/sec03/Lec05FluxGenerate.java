package com.demo.reactor.sec03;

import com.demo.reactor.utility.ReactorUtil;
import jdk.jshell.execution.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {

  public static void main(String[] args) {

  /*  Flux.generate(synchronousSink -> {
      synchronousSink.next(ReactorUtil.faker().country().name());
   //   synchronousSink.next(2); //-onError - More than one call to onNext
    }).subscribe(ReactorUtil.getDefaultSubscriber());
*/

    Flux.generate(synchronousSink -> {
          System.out.println("emitting");
      synchronousSink.next(ReactorUtil.faker().country().name());
     // synchronousSink.complete();
     //     synchronousSink.error(new RuntimeException("oops"));
    })
        .take(2)
        .subscribe(ReactorUtil.getDefaultSubscriber());

  }

}
