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
public class MonoVoidWarningExample {

    private static Mono<Void> doSomething() {
        return Mono.fromRunnable(() -> {
            System.out.println("do something...");
        });
    }

    public static void main(String[] args) {
        doSomething()
                .flatMap(value -> {
                    System.out.println("flatMap :: value =>"+ value);
                    return Mono.just(value);
                })
                .map(value -> {
                    System.out.println("map :: value =>"+ value);
                    return value;
                })
                .doOnNext(value -> {
                    System.out.println("doOnNext :: value =>"+ value);
                })
                .then(Mono.fromRunnable(() -> {
                    System.out.println("then do something ...");
                }))
                .doOnSuccess(value -> {
                    System.out.println("doOnSuccess :: value =>"+ value);
                })
                .subscribe();
    }

}
