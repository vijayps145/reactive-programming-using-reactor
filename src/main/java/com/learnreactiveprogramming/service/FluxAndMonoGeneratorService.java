package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.learnreactiveprogramming.util.CommonUtil.delay;

public class FluxAndMonoGeneratorService {

    static List<String> namesList = List.of("alex", "ben", "chloe");
    static List<String> namesList1 = List.of("adam", "jill", "jack");

    public Flux<String> namesFlux(){
        return Flux.fromIterable(namesList).log();
    }

    public Mono<String> nameMono(){
        return Mono.just("alex").log();
    }

    private String upperCase(String name) {
        delay(1000);
        return name.toUpperCase();
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();
        service.namesFlux()
                .subscribe(name -> {
                    System.out.println("Name is  : " + name);
                });


        service.nameMono()
                .subscribe(name -> {
                    System.out.println("Mono Name is  : " + name);
                });
    }
}
