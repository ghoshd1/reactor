package com.demo.reactor.sec04;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {

  public static void main(String[] args) {
    Flux.range(1,100)
        .log()
       // .limitRate(5) //75%
     //   .limitRate(5,3) //after 3 elements consumed request
     //   .limitRate(5,5) // defaults to 75%
        .limitRate(5,0) //drain everything before requesting
        .subscribe(ReactorUtil.getDefaultSubscriber());
  }

}
