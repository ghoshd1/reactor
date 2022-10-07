package com.demo.reactor.sec08.helper;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Qatar {

    public static Flux<String> getFlights(){
        return Flux.range(1, ReactorUtil.faker().random().nextInt(1, 5))
                    .delayElements(Duration.ofSeconds(1))
                    .map(i -> "Qatar " + ReactorUtil.faker().random().nextInt(100, 999))
                    .filter(i -> ReactorUtil.faker().random().nextBoolean());
    }

}