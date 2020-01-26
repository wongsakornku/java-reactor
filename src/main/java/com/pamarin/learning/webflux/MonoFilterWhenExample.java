/*
 * Copyright 2017-2019 Pamarin.com
 */
package com.pamarin.learning.webflux;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 *
 * @author jitta
 */
@Slf4j
public class MonoFilterWhenExample {

    public static void main(String[] args) {
        int randomNumber = (int) (Math.random() * 100); //0 to 100
        System.out.println("random number =>"+ randomNumber);
        Mono.just(randomNumber)
                .filterWhen(number -> {
                    return Mono.create(callback -> {
                        try {
                            System.out.println("wait 3 seconds... at " + LocalDateTime.now());
                            Thread.sleep(3000L);
                        } catch (InterruptedException ex) {
                            //
                        }
                        callback.success(number % 2 == 0);
                    });
                })
                .doOnNext(message -> {
                    System.out.println( message);
                })
                .doOnSuccess(message -> {
                    System.out.println("success at " + LocalDateTime.now());
                })
                .subscribe();
    }

}
