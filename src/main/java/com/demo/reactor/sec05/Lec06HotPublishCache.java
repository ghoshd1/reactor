package com.demo.reactor.sec05;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec06HotPublishCache {

  public static void main(String[] args) {
    // share = publish().refCount(1)
    // cache = publish().replay() int.max
    Flux<String> movieStream = Flux.fromStream(() -> getMovie())
        .delayElements(Duration.ofSeconds(1))
        .cache(2);

    ReactorUtil.sleepSeconds(2);

    movieStream
        .subscribe(ReactorUtil.getDefaultSubscriber("sam"));

    ReactorUtil.sleepSeconds(10);
    System.out.println("Mike is about to join");

    movieStream.subscribe(ReactorUtil.getDefaultSubscriber("mike"));

    ReactorUtil.sleepSeconds(60);


  }

  // movie-theatre
  private static Stream<String> getMovie(){
    System.out.println("Got the movie streaming req");
    return Stream.of(
        "Scene 1",
        "Scene 2",
        "Scene 3",
        "Scene 4",
        "Scene 5",
        "Scene 6",
        "Scene 7"
    );
  }



}