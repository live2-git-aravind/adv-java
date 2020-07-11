package java8;

import java.util.ArrayList;
import java.util.Optional;

public class OptionalDemo {
	static String testString;

	public static void main(String[] args) {
		Person person = null;
		ArrayList arrayList = null;
		Integer numbers[] = null;

		if (Math.random() > 0.5) {
			numbers = new Integer[3];
			numbers[0] = 100;
			testString = "Welcome";
			person = new Person();
			arrayList = new ArrayList();
			arrayList.add("smile");
			arrayList.add(null);
		}
		Optional optionalString =  Optional.ofNullable(testString);
		if(optionalString.isPresent())
		{ 
			System.out.println("Length of the string "+ testString.length());
			int length=optionalString.get().toString().length();
			System.out.println(length);
			
		}
		else {
			System.out.println("String May be NULL");
		}
		
		Optional arraylistOptional =  Optional.ofNullable(arrayList);
		
		if(arraylistOptional.isPresent())
		{ 
			System.out.println(arraylistOptional.get());
						
		}
		else
		{
			System.out.println("Arraylist Value May be NULL");
		}
		
Optional personOptional =  Optional.ofNullable(person);
		
		if(personOptional.isPresent())
		{ 
			System.out.println(personOptional);
						
		}
		else
		{
			System.out.println("Person may be NULL");
		}
		Optional optionalIntegerArray = Optional.ofNullable(numbers);
		if (optionalIntegerArray.isPresent()) {
			Integer[] tempArrayIntegers = (Integer[]) optionalIntegerArray.get();
			System.out.println(tempArrayIntegers[0]);
		}
		
	}
	
}


class Person {
	private String name = "Tester";

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}