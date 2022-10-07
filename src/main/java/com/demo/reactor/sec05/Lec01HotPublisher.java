package com.demo.reactor.sec05;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import java.util.stream.Stream;
import reactor.core.publisher.Flux;

public class Lec01HotPublisher {

  public static void main(String[] args) {

    Flux<String> movie = Flux.fromStream(() -> getMovie()).delayElements(Duration.ofSeconds(1)).share();

    movie.subscribe(ReactorUtil.getDefaultSubscriber("Sub1"));
    ReactorUtil.sleepSeconds(5);
    movie.subscribe(ReactorUtil.getDefaultSubscriber("Sub2"));

    ReactorUtil.sleepSeconds(10);
  }

  //Movie Theater
  private static Stream<String> getMovie(){
    System.out.println("Got Movie Streaming request");
    return Stream.of("Scene1","Scene2","Scene3","Scene4","Scene5");
  }
}
