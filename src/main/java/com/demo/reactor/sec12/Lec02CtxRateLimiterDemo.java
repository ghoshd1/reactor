package com.demo.reactor.sec12;


import com.demo.reactor.sec12.helper.BookService;
import com.demo.reactor.sec12.helper.UserService;
import com.demo.reactor.utility.ReactorUtil;
import reactor.util.context.Context;

public class Lec02CtxRateLimiterDemo {

    public static void main(String[] args) {

        BookService.getBook()
                .repeat(3)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "mike"))
                .subscribe(ReactorUtil.getDefaultSubscriber());





    }


}