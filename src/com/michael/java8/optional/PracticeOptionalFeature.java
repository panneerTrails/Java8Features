/**
 * 
 */
package com.michael.java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.michael.java8.practice.model.Modem;
import com.michael.java8.practice.model.PersonAsOptionalType;

/**
 * @author 109726
 *
 *The purpose of the class is to provide a type-level solution for representing optional values instead of using null references.
 */
public class PracticeOptionalFeature {

	public String getMyDefault() {
		System.out.println("Getting Default Value");
		return "Default Value";
	}

	public void whenCreatesEmptyOptional() {
		Optional<String> empty = Optional.empty();
		System.out.println("whenCreatesEmptyOptional_thenCorrect --> The result has to be true and it is : " + empty.isPresent());
	}

	public void givenNonNull_whenCreatesOptional() {
		String name = "baeldung";
		Optional<String> opt = Optional.of(name);
		System.out.println("givenNonNull_whenCreatesOptional_thenCorrect --> The result has to be Optional[baeldung] and it is : " + opt.toString());

	}

	public void givenNull_whenThrowsErrorOnCreate() {
		String name = null;
		try{
			Optional<String> opt = Optional.of(name);
		}catch (Exception e){
			System.out.println("givenNull_whenThrowsErrorOnCreate_thenCorrect --> " + e.toString());
		}
	}

	public void givenNonNull_whenCreatesNullable() {
		String name = "baeldung";
		Optional<String> opt = Optional.ofNullable(name);
		System.out.println("givenNonNull_whenCreatesNullable_thenCorrect --> The result has to be Optional[baeldung] and it is : " + opt.toString());
	}

	public void givenNull_whenCreatesNullable() {
		String name = null;
		Optional<String> opt = Optional.ofNullable(name);
		System.out.println("givenNull_whenCreatesNullable_thenCorrect --> The result has to be true and it is : " + opt.isPresent());
	}

	public void givenOptional_whenIfPresentWorks_thenCorrect() {
		Optional<String> opt = Optional.of("baeldung");
		opt.ifPresent(name -> System.out.println("givenOptional_whenIfPresentWorks_thenCorrect length of name --> " + name.length()));
	}

	public void whenOrElseWorks() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElse("john");
		System.out.println("whenOrElseWorks --> The result has to be john and it is : " + name);

	}

	public void whenOrElseGetWorks() {
		String nullName = null;
		//it takes a supplier functional interface which is invoked and returns the value of the invocation
		String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
		System.out.println("whenOrElseGetWorks --> The result has to be john and it is : " + name);

	}

	public void whenOrElseGetAndOrElseOverlap() {
		String text = null;	 
		System.out.println("Using orElseGet:");
		String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault); // supplier functional interface which is invoked and returns the value of the invocation
		System.out.println("whenOrElseGetAndOrElseOverlap - orElseGet --> " + defaultText);


		System.out.println("Using orElse:");
		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		System.out.println("whenOrElseGetAndOrElseOverlap - orElse --> " + defaultText);
	}


	/**
	 * Notice that when using orElseGet to retrieve the wrapped value, 
	 * the getMyDefault API is not even invoked since the contained value is present.
	 * However, when using orElse, whether the wrapped value is present or not, the default object is created. So in this case, 
	 * we have just created one redundant object that is never used.
	 * In this simple example, there is no significant cost to creating a default object, as the JVM knows how to deal with such.
	 * However, when a method such as getMyDefault has to make a web service call or even query a database, then the cost becomes very obvious
	 */
	public void whenOrElseGetAndOrElseDiffer() {
		String text = "Text present";

		System.out.println("Using orElseGet:");
		String defaultText 
		= Optional.ofNullable(text).orElseGet(this::getMyDefault); // supplier functional interface which is invoked and returns the value of the invocation
		System.out.println("whenOrElseGetAndOrElseDiffer - orElseGet --> " + defaultText);

		System.out.println("Using orElse:");
		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		System.out.println("whenOrElseGetAndOrElseDiffer - orElse --> " + defaultText);
	}

	public void whenOrElseThrowWorks() {
		String nullName = null;
		try{
			String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
		}catch(Exception e){
			System.out.println("whenOrElseThrowWorks - Exception thrown for -> " + nullName +" and it is  : " + e.toString());
		}
	}

	public void givenOptional_whenGetsValue() {
		Optional<String> opt = Optional.of("baeldung");
		String name = opt.get();
		System.out.println("givenOptional_whenGetsValue - get values has to be - baeldung and it is : " + name);
	}

	public void givenOptionalWithNull_whenGetThrowsException() {
		Optional<String> opt = Optional.ofNullable(null);
		try{
			String name = opt.get();
		}catch(Exception e){
			System.out.println("givenOptionalWithNull_whenGetThrowsException - Exception thrown for null -> " + e.toString());
		}
	}


	/*
	 * The filter API is normally used this way to reject wrapped values based on a predefined rule. You could use it to reject a wrong email format or a password that is not strong enough.
	 */
	public void whenOptionalFilterWorks() {
		Integer year = 2016;
		Optional<Integer> yearOptional = Optional.of(year);
		boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent(); // Takes a predicate 'y -> y == 2016' as an argument to test the wrapped value
		System.out.println("whenOptionalFilterWorks - filter expected to return true for 2016 and the result is : " + is2016);

		boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
		System.out.println("whenOptionalFilterWorks - filter expected to return false for 2017 and the result is : " + is2017);
	}


	/**
	 * Traditional way of price range check after checking null
	 * @param modem
	 * @return
	 */
	public boolean priceIsInRange1(Modem modem) {
		boolean isInRange = false;

		if (modem != null && modem.getPrice() != null
				&& (modem.getPrice() >= 10
				&& modem.getPrice() <= 15)) {

			isInRange = true;
		}
		return isInRange;
	}


	/**
	 * Optional filter API way of price range check
	 * @param modem2
	 * @return
	 */
	public boolean priceIsInRange2(Modem modem2) {
		//Double price = Optional.ofNullable(modem2).map(Modem::getPrice).get();
		//System.out.println("The map value is :" + price);

		boolean  isPrice = Optional.ofNullable(modem2).map(Modem::getPrice).isPresent();
		System.out.println("The map value is :" + isPrice);


		return Optional.ofNullable(modem2)
				.map(Modem::getPrice)
				.filter(p -> p >= 10)
				.filter(p -> p <= 15)
				.isPresent();
	}

	/**
	 * The map API returns the result of the computation wrapped inside Optional.
	 */
	public void givenOptional_whenMapWorksOnList() {
		List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
		Optional<List<String>> listOptional = Optional.of(companyNames);
		int size = listOptional.map(List::size).orElse(0);
		System.out.println("givenOptional_whenMapWorksOnList - The size of the list has to be 6 and it is :" + size);
	}

	public void givenOptional_whenMapWorks_thenCorrectSingleString() {
		String name = "PhilominRaj";
		Optional<String> nameOptional = Optional.of(name);	 
		int len = nameOptional.map(String::length).orElse(0);
		System.out.println("givenOptional_whenMapWorksOnList - The length of the string has to be 11 and it is :" + len);
	}

	public void givenOptional_whenMapWorksWithFilter() {
		String password = " password ";
		Optional<String> passOpt = Optional.of(password);
		boolean correctPassword = passOpt.filter(pass -> pass.equals("password")).isPresent();
		System.out.println("givenOptional_whenMapWorksWithFilter_thenCorrect - Filter without Map for trim password :" + correctPassword);

		correctPassword = passOpt.map(String::trim).filter(pass -> pass.equals("password")).isPresent();
		System.out.println("givenOptional_whenMapWorksWithFilter_thenCorrect - Filter with Map for trimmed password :" + correctPassword);
	}


	/**
	 * The difference is that map transforms values only when they are unwrapped whereas flatMap takes a wrapped value and unwraps it before transforming it.
	 */
	public void givenOptional_whenFlatMapWorks() {
		PersonAsOptionalType person = new PersonAsOptionalType("john", 26);
		Optional<PersonAsOptionalType> personOptional = Optional.of(person);

		Optional<Optional<String>> nameOptionalWrapper  = personOptional.map(PersonAsOptionalType::getName);
		Optional<String> nameOptional  = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
		String name1 = nameOptional.orElse("");
		System.out.println("givenOptional_whenMapWorks - The retrieved name should be john and it is :" + name1);

		Optional<String> nameOptionalViaFlatMap = personOptional.flatMap(PersonAsOptionalType::getName);
		String name = nameOptionalViaFlatMap.orElse("");
		System.out.println("givenOptional_whenFlatMapWorks - The retrieved name should be john and it is :" + name);

	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PracticeOptionalFeature pf = new PracticeOptionalFeature();
		pf.whenCreatesEmptyOptional();
		pf.givenNonNull_whenCreatesOptional();
		pf.givenNull_whenThrowsErrorOnCreate();
		pf.givenNonNull_whenCreatesNullable();
		pf.givenNull_whenCreatesNullable();
		pf.givenOptional_whenIfPresentWorks_thenCorrect();
		pf.whenOrElseWorks();
		pf.whenOrElseGetWorks();
		pf.whenOrElseGetAndOrElseOverlap();
		pf.whenOrElseGetAndOrElseDiffer();
		pf.whenOrElseThrowWorks();
		pf.givenOptional_whenGetsValue();
		pf.givenOptionalWithNull_whenGetThrowsException();
		pf.whenOptionalFilterWorks();

		// Modem with positive scenario
		Modem mps = new Modem(12.2);
		System.out.println("The result of priceIsInRange1 - Positive Scenario : " + pf.priceIsInRange1(mps));
		System.out.println("The result of priceIsInRange2 - Positive Scenario : " + pf.priceIsInRange2(mps));

		// Modem with negative scenario
		Modem mns = new Modem(15.8);
		System.out.println("The result of priceIsInRange2 - Negative Scenario : " + pf.priceIsInRange2(mns));

		// Modem with negative scenario with NULL as an argument
		Modem mnsNull = new Modem(null);
		System.out.println("The result of priceIsInRange2 - Negative Scenario with NULL as an argument : " + pf.priceIsInRange2(mnsNull));

		pf.givenOptional_whenMapWorksOnList();
		pf.givenOptional_whenMapWorks_thenCorrectSingleString();
		pf.givenOptional_whenMapWorksWithFilter();
		pf.givenOptional_whenFlatMapWorks();
	}

}
