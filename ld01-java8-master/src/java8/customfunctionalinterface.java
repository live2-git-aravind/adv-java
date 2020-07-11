package java8;



public class customfunctionalinterface {
	public static void main(String[] args) {
		Integer[] intArray = {5,6,7,8};
		Counter counter=Utils::countElements;
		System.out.println(counter.count(intArray));
		Utils objUtils = new Utils();
		Counter counter1=objUtils::countElementsInstance;
		System.out.println(counter1.count(intArray));
	}
}
@FunctionalInterface
interface Counter {
	int count(Object[] objArray);
}


class Utils {
	public static int countElements(Object[] array) {
		return array.length; 
		}
	public int countElementsInstance(Object[] array) {
		return array.length;
	
	}
}


