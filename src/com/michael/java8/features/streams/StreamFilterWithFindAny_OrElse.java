/**
 * 
 */
package com.michael.java8.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author 109726
 *
 */
public class StreamFilterWithFindAny_OrElse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Person result1 = persons.stream()                        // Convert to steam
                .filter(x -> "jack".equals(x.getName()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);                                  // If not found, return null

        System.out.println("result1 - Stream Filter with findAny - Existence :" + result1);
        
        Person result2 = persons.stream()
                .filter(x -> "ahmook".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println("result2 - Stream Filter with findAny - Non existence :" + result2);
        
        
        Person result3 = persons.stream()                        // Convert to steam
                .filter(x -> "jack".equals(x.getName()))        // we want "jack" only
                .findFirst()                                      // If 'findAny' then return found
                .orElse(null);                                  // If not found, return null

        System.out.println("result3 - Stream Filter with findFirst - Existence :" + result3);
        
        Person result4 = persons.stream()
                .filter(x -> "ahmook".equals(x.getName()))
                .findFirst()
                .orElse(null);

        System.out.println("result4 - Stream Filter with findFirst - Non eExistence :" + result4);
        
       
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> result5 = intList.stream().filter(num -> num < 4).findAny();        
        if(result5.isPresent()){
        	System.out.println("result5 - sequence with findAny :" + result5.get());
        }
     
        Optional<Integer> result6 = intList.stream().parallel().filter(num -> num < 4).findAny();
        if(result6.isPresent()){
        	System.out.println("result6 - parallel with findAny :" + result6.get());
        }
        
        Optional<Integer> result7 = intList.stream().filter(num -> num < 4).findFirst();       
        if(result7.isPresent()){
        	System.out.println("result7 - sequence with findFirst :" + result7.get());
        }
     
        Optional<Integer> result8 = intList.stream().parallel().filter(num -> num < 4).findFirst();
        if(result8.isPresent()){
        	System.out.println("result8 - sequence with findFirst :" + result8.get());
        }
	}
	

}
