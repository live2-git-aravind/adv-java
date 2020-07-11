package streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreamPerformanceTest {
	public static void main(String[] args) {
		long stime =sequentialStream();
		long ptime =parallelStream();
		System.out.println("++++++++++++++++");
		System.out.println("Time difference in running sequentially and parallel:"+ (stime-ptime));
	}

	private static long sequentialStream() {
		// create the source list
		List<Integer> productList = new ArrayList<Integer>();

		productList.add(1000);
		for (int i = 0; i < 100; i++) {
			int lastValue = productList.get(i);
			productList.add(lastValue + 1000);
		}
		System.out.println("BEFORE PROCESSING " + productList);
		//System.out.println("Input List ---> " + productList);
		//Returns a sequential Stream with this collection as its source.
		//productList.stream().filter(element -> (element >5000) && (element <10000)).forEach(System.out::println);
		List serialList = new ArrayList();
		long started = System.nanoTime();
		productList.stream().filter(element -> (element >5000) && (element <10000)).forEach(element -> {
		System.out.println("sequential >"+ Thread.currentThread().getName()+" > "+element);
		serialList.add(element);
		});
		long finished=System.nanoTime();
		long timeelasped = finished - started;
		System.out.println("Serial List"+serialList);
		System.out.println("timeelapasedsequential"+timeelasped);
		System.out.println("Afterprocessing"+productList);
		
		
		
		return timeelasped;
	}
	
	
	private static long parallelStream() {
		// create the source list
		List<Integer> productList = new ArrayList<Integer>();

		productList.add(1000);
		for (int i = 0; i < 100; i++) {
			int lastValue = productList.get(i);
			productList.add(lastValue + 1000);
		}
		System.out.println("BEFORE PROCESSING " + productList);
		//System.out.println("Input List ---> " + productList);
		//Returns a parallel Stream with this collection as its source.
		//productList.parallelStream().filter(element -> (element >5000) && (element <10000)).forEach(System.out::println);
		//List serialList = new ArrayList();
		List serialList = new ArrayList();
		long started = System.nanoTime();
		productList.parallelStream().filter(element -> (element >5000) && (element <10000)).forEach(element -> {
		System.out.println("Parallel >"+ Thread.currentThread().getName()+" > "+element);
		serialList.add(element);
		});
		long finished=System.nanoTime();
		long timeelasped = finished - started;
		System.out.println("Serial List"+serialList);
		System.out.println("timeelapasedparallel"+timeelasped);
		System.out.println("Afterprocessing"+productList);
		
		
		
		return timeelasped;
	}

//	private static long parallelStream() {
//		return null;
//	}
}