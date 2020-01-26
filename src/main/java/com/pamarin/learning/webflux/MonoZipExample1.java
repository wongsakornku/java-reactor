/*
 * Copyright 2017-2019 Pamarin.com
 */
package com.pamarin.learning.webflux;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 *
 * @author jitta
 */
@Slf4j
public class MonoZipExample1 {
    
    private static void delay(String name, int seconds) {
        try {
            System.out.println("{} wait {} seconds"+ name+" "+ seconds);
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ex) {

        }
    }

    public static void main(String[] args) {
        
        Mono<String> task1 = Mono.create(callback -> {
            delay("task 1", 3);
            callback.success("Hello from Task 1");
        });
        
        Mono<String> task2 = Mono.create(callback -> {
            delay("task 2", 1);
            callback.success("Hello from Task 2");
        });
 
        System.out.println("start at"+ LocalDateTime.now());
        
        Mono.zip(task1, task2)
                .doOnNext(response -> {
                    System.out.println("task 1->"+ response.getT1());
                    System.out.println("task 2->"+ response.getT2());
                })
                .doOnSuccess(response -> {
                    System.out.println("end at"+ LocalDateTime.now());
                })
                .subscribe();
    }
    
}
