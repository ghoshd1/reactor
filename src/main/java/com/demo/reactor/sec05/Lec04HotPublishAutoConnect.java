package com.demo.reactor.sec05;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import java.util.stream.Stream;
import reactor.core.publisher.Flux;

public class Lec04HotPublishAutoConnect {

  public static void main(String[] args) {

    Flux<String> movie = Flux.fromStream(Lec04HotPublishAutoConnect::getMovie).delayElements(Duration.ofSeconds(1))
        .publish()
        .autoConnect(1);


    movie.subscribe(ReactorUtil.getDefaultSubscriber("Sub1"));
    ReactorUtil.sleepSeconds(10);
    System.out.println("Subscriber 2 about to join");
    movie.subscribe(ReactorUtil.getDefaultSubscriber("Sub2"));

    ReactorUtil.sleepSeconds(10);
  }

  //Movie Theater
  private static Stream<String> getMovie(){
    System.out.println("Got Movie Streaming request");
    return Stream.of("Scene1","Scene2","Scene3","Scene4","Scene5");
  }
}
