package com.demo.reactor.sec09;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import reactor.core.publisher.Flux;

public class Lec01BufferTimeout {

  public static void main(String[] args) {

    eventStream()
       // .buffer(Duration.ofSeconds(2))
        .bufferTimeout(5,Duration.ofSeconds(2))
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
