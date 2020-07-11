package java7;

public class PolymorphismUsingWrappers {
	public static void main(String[] args) {
		int i = 100;
		float f = 500.50f;
		boolean bool=true;
		char ch='A';
		

		Number numbers[] = new Number[2];
		// boxed and upcasted
		// specific object is stored in a generic array
		numbers[0] = new Integer(i);
		numbers[1] = new Float(f);

		for (Number number : numbers) {
			System.out.println(number);
		}

		// storing user defined + wrappers in the same object array.
		Object objects[] = new Object[4];
		objects[0] = new Integer(i);
		objects[1] = new Float(f);
		objects[2] = new Boolean(bool);
		objects[3] = new Character(ch);
		
		for (Object object : objects) {
			System.out.println(object);
			
		}
		
		
	}

		

   
   
		   }

