/*
 * Copyright 2017-2019 Pamarin.com
 */
package com.pamarin.learning.webflux;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 *
 * @author jitta
 */
@Slf4j
public class MonoFlowExample {

    public static void main(String[] args) {
        Mono.just("A")
                .doFirst(() -> System.out.println("doFirst..."))
                .doOnRequest(value -> System.out.println("doOnRequest..."+ value))
                .doOnEach(signal -> System.out.println("doOnEach... {} : value =>"+ signal.getType().name()+" "+signal.get()))
                .doOnNext(value -> System.out.println("doOnNext..."+ value))
                .doOnCancel(() -> System.out.println("doOnCacel..."))
                .doOnError(e -> System.out.println("doOnError..."+ e.getMessage()))
                .doOnSuccess(value -> System.out.println("doOnSuccess..."+ value))
                .doOnSuccessOrError((value, e) -> System.out.println("doOnSuccessOrError... {} or"+ value+" "+ (e == null ? null : e.getMessage())))
                .doAfterSuccessOrError((value, e) -> System.out.println("doAfterSuccessOrError... {} or"+ value+" "+(e == null ? null : e.getMessage())))
                .doAfterTerminate(() -> System.out.println("doAfterTerminate..."))
                .doOnTerminate(() -> System.out.println("doOnTerminate..."))
                .doOnSubscribe(subscription -> {
                    long id = 1234567890;
                    subscription.request(id);
                    System.out.println("doOnSubscribe..."+ id);
                })
                .doFinally(signalType -> System.out.println("doFinally..."+ signalType.toString()))
                .doOnDiscard(Object.class, value -> System.out.println("doOnDiscard..."+ value))
                .subscribe();
    }

}
