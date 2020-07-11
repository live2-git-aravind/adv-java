package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorLamda {
	public static void main(String[] args) {
	List<String> list = Arrays.asList("java","JAVA","jAva","sql","100","50");
//		Collections.sort(list);
//		System.out.println(list);
		
		//custom sorting
		//Comparator<String> comparatorlamda = (string1,string2) ->Integer.compare(string1.length(),string2.length());
		//use the comparator to sort
		
//	     Collections.sort(list, comparatorlamda);
//	     System.out.println(list);

	     Collections.sort(list, (string1,string2) -> Integer.compare(string1.length(), string2.length()));
	     System.out.println(list);
	     Collections.sort(list, (string1,string2) -> Integer.compare(string2.length(), string1.length()));
	     System.out.println(list);
	}

}
