package com.demo.reactor.sec10;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

public class Lec03RetryWhenAdvanced {


  public static void main(String[] args) {

    orderService(ReactorUtil.faker().business().creditCardNumber())
        .retryWhen(Retry.from(
            flux -> flux
                .doOnNext(rs -> {
                  System.out.println(rs.totalRetries());
                  System.out.println(rs.failure());
                })
                .handle((rs, synchronousSink) -> {
                  if(rs.failure().getMessage().equals("500"))
                    synchronousSink.next(1);
                  else
                    synchronousSink.error(rs.failure());
                })
                .delayElements(Duration.ofSeconds(1))

        ))
        .subscribe(ReactorUtil.getDefaultSubscriber());

    ReactorUtil.sleepSeconds(60);


  }


  // order service
  private static Mono<String> orderService(String ccNumber){
    return Mono.fromSupplier(() -> {
      processPayment(ccNumber);
      return ReactorUtil.faker().idNumber().valid();
    });
  }

  // payment service
  private static void processPayment(String ccNumber){
    int random = ReactorUtil.faker().random().nextInt(1, 10);
    if(random < 10)
      throw new RuntimeException("500");
    else if(random < 10)
      throw new RuntimeException("404");
  }

}

