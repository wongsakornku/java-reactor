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
public class FluxTakeExample {
    
     public static void main(String[] args) {
        Flux.just("A", "B", "C", "D", "E", "F", "G", "H")
                .skip(2)
                .take(3)
                .doOnNext(message -> {
                    System.out.println( message);
                })
                .subscribe();
    }

    
}
