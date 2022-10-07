package com.demo.reactor.sec04;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

public class Lec05Delay {

  public static void main(String[] args) {

   // Queues

    System.setProperty("reactor.bufferSize.x", "20");

    Flux.range(1,100)
        .log()
        .delayElements(Duration.ofSeconds(1)) //75% limit rate in build
        .log()
        .subscribe(ReactorUtil.getDefaultSubscriber("Deb"));

    ReactorUtil.sleepSeconds(60);
  }

}
