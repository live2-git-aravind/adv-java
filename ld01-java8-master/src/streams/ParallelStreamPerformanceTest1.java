package streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreamPerformanceTest1 {
	public static void main(String[] args) {
		// create the source list
		List<Integer> productList = new ArrayList<Integer>();
		productList.add(1000);
		for (int i = 0; i < 10; i++) {
			int lastValue = productList.get(i);
			productList.add(lastValue + 1000);
		}

		System.out.println("Input List ---> " + productList);

		long start = System.nanoTime();
		List seralList = new ArrayList();
		// Returns a sequential Stream with this collection as its source.
		// A sequence of elements supporting sequential and parallel aggregate
		// operations.
		// Returns a stream consisting of the elements of this stream that match the
		// given predicate.
		//productList.stream().filter(element -> element > 5000).forEach(System.out::println);
		
		 for (Integer product : productList) {
			 if(product >5000 && product < 10000 )
			 {
				 System.out.println(product.intValue());
			 }
			
		}

	}
}


