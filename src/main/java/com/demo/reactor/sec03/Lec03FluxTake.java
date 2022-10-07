package com.demo.reactor.sec03;

import com.demo.reactor.sec03.helper.NameProducer;
import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {

  public static void main(String[] args) {


    Flux.range(1,10)
        .take(3)
        .subscribe(ReactorUtil.getDefaultSubscriber());


  }
}
