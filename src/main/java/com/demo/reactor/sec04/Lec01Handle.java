package com.demo.reactor.sec04;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec01Handle {

  public static void main(String[] args) {

    //handle=filter+map
    Flux.range(1,10)
        .handle((integer, synchronousSink) -> {

          if(integer%2==0) //filter
            synchronousSink.next(integer);
          else if(integer==7)
            synchronousSink.complete();
            synchronousSink.next(integer+"a");//map
        }).subscribe(ReactorUtil.getDefaultSubscriber());




  }

}
