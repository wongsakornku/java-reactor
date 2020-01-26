/*
 * Copyright 2017-2019 Pamarin.com
 */
package com.pamarin.learning.webflux;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 *
 * @author jitta
 */
@Slf4j
public class FluxFlatMapExample {
    
    public static void main(String[] args) {
        Flux.just(1, 2, 3, 4, 5)
                .flatMap(number -> {
                    return Flux.create(callback -> {
                        try {
                            System.out.println("wait 3 seconds... at " + LocalDateTime.now());
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            
                        }
                        callback.next(number * 10);
                        callback.complete();
                    });
                })
                .doOnNext(message -> {
                    System.out.println( message);
                })
                .subscribe();
    }
    
}
