package streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapFilterReduce {
	public static void main(String[] args) {
		mapping_operation();
		mapping_filter();
		reduce_operation();
	}
	
	private static void reduce_operation() {
		int salary[] = {20000,30000,100};
	
		IntStream salaryStream = Arrays.stream(salary);
	 int sum =salaryStream.sum();
	System.out.println(sum);
	System.out.println(Arrays.stream(salary).max());
	System.out.println(Arrays.stream(salary).min());
	System.out.println(Arrays.stream(salary).count());
		
	}
	
	private static void mapping_operation() {
		
		String [] players = new String[] {"syam","balu","suri","aru"};
		
		Stream<String> playerStream = Arrays.stream(players);
		Stream<String> upperStream = playerStream.map(player -> player.toUpperCase());
		//Stream<String> lowerStream = playerStream.flatMap(player -> player.toLowerCase());
		String [] uppercaseplayerStrings= upperStream.toArray(String[]::new);
		//String [] lowercaseplayerStrings = u
		for (String string : uppercaseplayerStrings) {
			System.out.println(string);
		}
	}
		private static void mapping_filter() {
			
			String [] players = new String[] {"syam","balu","suri","aru"};
			
			Stream<String> playerStream = Arrays.stream(players);
			Stream<String> filteredStream = playerStream.filter(player -> player.length()>3);
			//Stream<String> lowerStream = playerStream.flatMap(player -> player.toLowerCase());
			String [] newplayers= filteredStream.toArray(String[]::new);
			//String [] lowercaseplayerStrings = u
			for (Object object : newplayers) {
				System.out.println(object);
			}
		
	}



}
