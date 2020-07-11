package java7;

import java.util.Arrays;

public class DeepClone {
public static void main(String[] args) {
ObjectToBeDeepCloned.cloneTest();

}
}

class ObjectToBeDeepCloned implements Cloneable{
	// THE INT ARRAY IS SHALLOW CLONED AS ONLY THE ADDRESS IS COPIED AND THE VALUES
	// ARE NOT COPIED
	//public int[] numbers;
	public String nameString = "Rambo";
	public float value = 5.5f;
	public Float[] floatWrapper;
	public Test test = new Test();

	public ObjectToBeDeepCloned(int size) {
		floatWrapper = new Float [size];
	}
	
	static void cloneTest() {
		ObjectToBeDeepCloned originalObject = new ObjectToBeDeepCloned(2);
		//originalObject.numbers[0] = 100;
		originalObject.floatWrapper[0] = 23.45f;
		
		try {
			ObjectToBeDeepCloned clonedObject = (ObjectToBeDeepCloned)originalObject.clone();
			System.out.println("Original      " + originalObject);
			System.out.println("Cloned      " + clonedObject);
			
			clonedObject.nameString = "John";
			clonedObject.floatWrapper[0] = 789.987f;
			//clonedObject.test.nameString = "Virus!";
			clonedObject.value = 500.500f;
			//originalObject.value = 500.500f;
			//clonedObject.numbers[1] = 5000;
			
//			// AFTER CLONING
			System.out.println("Original      " + originalObject);
			System.out.println("Cloned      " + clonedObject);
			
		} catch (CloneNotSupportedException e) {
			System.out.println("You cannot clone this object!" + e);
		}

	}

	@Override
	public String toString() {
		return "ObjectToBeDeepCloned [floatWrapper=" + Arrays.toString(floatWrapper) + ", nameString=" + nameString + ", value="
				+ value + ", test=" + test + "]";
	}
}
class Test1 {
	String nameString = "Tester";

	@Override
	public String toString() {
		return "Test [nameString=" + nameString + "]";
	}

}