/*
 * Copyright 2017-2019 Pamarin.com
 */
package com.pamarin.learning.webflux;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 *
 * @author jitta
 */
@Slf4j
public class FluxFlowExample {

    public static void main(String[] args) {
        Flux.just("A", "B", "C")
                .doFirst(() -> System.out.println("doFirst..."))
                .doOnRequest(value -> System.out.println("doOnRequest..."+ value))
                .doOnEach(signal -> System.out.println("doOnEach... {} : value =>"+ signal.getType().name()+" "+ signal.get()))
                .doOnNext(value -> System.out.println("doOnNext..."+ value))
                .doOnCancel(() -> System.out.println("doOnCacel..."))
                .doOnError(e -> System.out.println("doOnError..."+ e.getMessage()))
                .doOnComplete(() -> System.out.println("doOnComplete..."))
                .doAfterTerminate(() -> System.out.println("doAfterTerminate..."))
                .doOnTerminate(() -> System.out.println("doOnTerminate..."))
                .doOnSubscribe(subscription -> {
                    long id = 123456890;
                    subscription.request(id);
                    System.out.println("doOnSubscribe..."+ id);
                })
                .doFinally(signalType -> System.out.println("doFinally..."+ signalType.toString()))
                .doOnDiscard(Object.class, value -> System.out.println("doOnDiscard..."+ value))
                .subscribe();
    }

}
