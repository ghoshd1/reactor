package com.demo.reactor.sec10;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import javax.xml.transform.stream.StreamSource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.RetrySpec;

public class Sample1 {

  public static void main(String[] args) {
    Flux<Object> flux1 = Flux.just("a", "b", "c");



    flux1
        .doOnNext(o ->process(o.toString()) )
        .retryWhen(RetrySpec.fixedDelay(3, Duration.ofSeconds(1)))
//        .onErrorContinue((throwable, o) -> {
//            System.out.println("throwable");
//        })
        .onErrorResume(throwable -> Mono.empty())
        .repeat()
        .subscribe(subscribedValue -> System.out.println("Msg Subscribed->"+subscribedValue));


    ReactorUtil.sleepSeconds(8);
  }

  private static Mono<String> process(String o){
    if(o=="b")
      throw new RuntimeException("InvalidArgument");
    else{
      return Mono.just(o);
    }
  }

  //  .retryWhen(
//      Retry.backoff(3, Duration.ofSeconds(2))
//      .onRetryExhaustedThrow(
//                (retryBackoffSpec, retrySignal) -> {
//    throw new RetriesExhaustedException("Failed to process after max retries");
//  }))

}
