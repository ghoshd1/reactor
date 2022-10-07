package com.demo.reactor.sec05;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import java.util.stream.Stream;
import reactor.core.publisher.Flux;

public class Lec05HotPublishAutoConnect {

  //No need to subscribe
  public static void main(String[] args) {

    Flux<String> movie = Flux.fromStream(Lec05HotPublishAutoConnect::getMovie).delayElements(Duration.ofSeconds(2))
        .publish()
        .autoConnect(0);

    ReactorUtil.sleepSeconds(5);
    System.out.println("Subscriber 1 about to join");
    movie.subscribe(ReactorUtil.getDefaultSubscriber("Sub1"));
    ReactorUtil.sleepSeconds(10);
    System.out.println("Subscriber 2 about to join");
    movie.subscribe(ReactorUtil.getDefaultSubscriber("Sub2"));

    ReactorUtil.sleepSeconds(20);
  }

  //Movie Theater
  private static Stream<String> getMovie(){
    System.out.println("Got Movie Streaming request");
    return Stream.of("Scene1","Scene2","Scene3","Scene4","Scene5");
  }
}
