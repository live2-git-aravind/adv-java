package java8;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {
	public static void main(String[] args) {
		objectinstanceMethodreference();

	}

	private static void objectinstanceMethodreference() {
		List<String> namelist = new ArrayList<String>();
		namelist.add("Aravind");
		namelist.add("Geetha");
		namelist.add("Purvi");
		namelist.forEach(item -> System.out.println(item));
		namelist.forEach(System.out::println);
		namelist.forEach(item ->{ if(item.length()>5)  
		System.out.println("Condition:" +item);});
			
		
	}

}
