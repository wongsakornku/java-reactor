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
public class FluxRepeatExample {
    
    public static void main(String[] args) {
        Flux.just("1", "2", "3")
                .repeat(1)
                .doOnNext(message -> {
                    System.out.println( message);
                })
                .subscribe();
    }
    
}
