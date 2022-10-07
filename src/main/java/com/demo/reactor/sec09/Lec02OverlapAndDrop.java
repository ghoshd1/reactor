package com.demo.reactor.sec09;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import reactor.core.publisher.Flux;

public class Lec02OverlapAndDrop {

  public static void main(String[] args) {
    eventStream()
     //    .buffer(3,1)//skip the 1 old record from the list and add 1 new at the end
        .buffer(3,5)//skip the last 5 old record and take 3
        .subscribe(ReactorUtil.getDefaultSubscriber());

    ReactorUtil.sleepSeconds(100);
  }


  private static Flux<String> eventStream() {
    return Flux.interval(Duration.ofMillis(300))
        .handle((aLong, synchronousSink) -> {
          if(aLong>1000)
            synchronousSink.complete();
          else
            synchronousSink.next(aLong);
        })
        .map(i -> "event" + i);
  }

}
