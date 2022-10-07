package com.demo.reactor.sec12;


import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class Lec01Ctx {

    public static void main(String[] args) {

        getWelcomeMessage()
            //    .contextWrite(ctx -> ctx.put("user", ctx.get("user").toString().toUpperCase()))
                .contextWrite(Context.of("user", "sam"))
                .subscribe(ReactorUtil.getDefaultSubscriber());

    }


    private static Mono<String> getWelcomeMessage(){
        return Mono.deferContextual(ctx -> {
            if(ctx.hasKey("user")){
                return Mono.just("Welcome  " + ctx.get("user"));
            }else{
                return Mono.error(new RuntimeException("unauthenticated"));
            }
        });
    }


}