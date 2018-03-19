package com.michael.java8.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamFilterWithMap {
	
	public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40),
                new Person("jack", 50)
        );

        int age = persons.stream()
        		//.parallel()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getAge)                        //convert stream to String
                .findAny()
               // .findFirst()
                .orElse(0);

        System.out.println("name : " + age);

        List<String> collectedAsList = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("Results Collected As List \n" );
        collectedAsList.forEach(System.out::println);
        
        Set<String> collectAsSet = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toSet());
        System.out.println("Results Collected As Set \n" );
        collectAsSet.forEach(System.out::println);

    }


}
