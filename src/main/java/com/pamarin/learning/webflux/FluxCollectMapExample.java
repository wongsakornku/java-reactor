/*
 * Copyright 2017-2019 Pamarin.com
 */
package com.pamarin.learning.webflux;

import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 *
 * @author jitta
 */
@Slf4j
public class FluxCollectMapExample {

    public static void main(String[] args) {
        Flux.just(
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        )
                .collectMap(value -> value.substring(0, 3))
                .doOnNext(map -> {
                    System.out.println(map.size());
                    System.out.println("map =>"+ map);
                    System.out.println("day =>"+ map.get("Sun"));
                    System.out.println("day =>"+ map.get("Mon"));
                    System.out.println("day =>"+ map.get("Tue"));
                    System.out.println("day =>"+ map.get("Wed"));
                    System.out.println("day =>"+ map.get("Thu"));
                    System.out.println("day =>"+ map.get("Fri"));
                    System.out.println("day =>"+ map.get("Sat"));
                })
                .subscribe();
    }

}
