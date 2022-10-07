package com.demo.reactor.sec10;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

public class Sample {

  public static void main(String[] args) {
    Flux<Object> flux1 = Flux.just("a", "b", "c");
    Flux<Object> error = Flux.error(new Throwable(""));
    Flux<Object> flux2 = Flux.just("1", "2", "3");

    Flux<Object> concat = Flux.concat(flux1, error, flux2);

    concat
       // .retryWhen(Retry.backoff(3, Duration.ofSeconds(2)))
        .onErrorContinue((throwable, o) -> System.out.println("throwable"))
        .subscribe(o -> System.out.println(o));


    ReactorUtil.sleepSeconds(20);
  }
//  .retryWhen(
//      Retry.backoff(3, Duration.ofSeconds(2))
//      .onRetryExhaustedThrow(
//                (retryBackoffSpec, retrySignal) -> {
//    throw new RetriesExhaustedException("Failed to process after max retries");
//  }))

}
