package com.demo.reactor.sec08.helper;


import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Emirates {

    public static Flux<String> getFlights(){
        return Flux.range(1, ReactorUtil.faker().random().nextInt(1, 10))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Emirates " + ReactorUtil.faker().random().nextInt(100, 999))
                .filter(i -> ReactorUtil.faker().random().nextBoolean());
    }


}