
package java8;

public class DefaultStaticAbstract {
public static void main(String[] args) {
	//The abstract class constructor is invoked implicitly
	DerivedFromAbstract derivedFromAbstract = new DerivedFromAbstract();
	System.out.println(derivedFromAbstract.message);
	
	//Interface static methods
	//InterfaceTest.test1();
	
	//InterfaceTest.test2();
	
	//The Test 2 may or may not be overridden in the derived class.
	derivedFromAbstract.test2();
	
	//The test1 is an instance method and a brand new one
	derivedFromAbstract.test1();
	
	InterfaceTest interfaceTest = new DerivedFromAbstract();
	interfaceTest.test2();
}
}

abstract class AbstractTest{
	public String message;
	public AbstractTest() {
		message = "Abstract Message";
	}
	
	public abstract void test();
	public void test1() {
		
	}
}

class DerivedFromAbstract extends AbstractTest implements InterfaceTest{

	@Override
	public void test() {
		System.out.println("Overridden!");
		System.out.println(message);
	}
	@Override
	public void test2() {
		System.out.println("Overridden!. This is cool :)");
		//System.out.println(message);
	}
	public  void test1() {
		System.out.println("This is a new method.....");
	}
}
interface InterfaceTest{
//	public InterfaceTest() {
//		
//	}
	public abstract void test();
//	This method strictly belongs to the interface
	public static void test1() {
		System.out.println("It's great, that interface can now have a bit of functionality too!");
	}
	public default void test2() {
		System.out.println("This is a method for the implementing instances");
	}
}