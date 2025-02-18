package com.learnreactiveprogramming.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalExample {

    public static void main(String[] args) {

        var namesList = List.of("alex","ben","chloe","adam","adam");
        var newNamesList = namesGreaterThanSize(namesList,3);
        System.out.println(newNamesList);

    }

    private static List<String> namesGreaterThanSize(List<String> namesList, int size) {
        var newNamesList =  namesList.stream().filter( s -> s.length() > 3)
                .map(String::toUpperCase)
                .distinct().collect(Collectors.toList());
            return newNamesList;
    }
}
