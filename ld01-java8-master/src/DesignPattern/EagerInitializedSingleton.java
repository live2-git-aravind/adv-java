package DesignPattern;

public class EagerInitializedSingleton {
// Single to n - singleton
//Single object  will be created for an application
//Developer should use only one object
//Developer Cannot create the instance accidentally.
	public static void main(String[] args) {
		singleton_coffeevendingmachine Singleton_coffeevendingmachine = singleton_coffeevendingmachine.getInstance();
		Singleton_coffeevendingmachine.brewAcupofCoffee();
		singleton_coffeevendingmachine singleton_coffeevendingmachine1=singleton_coffeevendingmachine.getInstance();
		singleton_coffeevendingmachine1.brewAcupofCoffee();
		System.out.println(Singleton_coffeevendingmachine);
		System.out.println(singleton_coffeevendingmachine1);
	}

}


class singleton_coffeevendingmachine
{
	// Step 1: Create a variable which is 1.Private 2.static 3.final
	private static final singleton_coffeevendingmachine Instance_singleton_coffee_vending_machine= new singleton_coffeevendingmachine();
	
	//step 2: Create a private constructor
	private singleton_coffeevendingmachine() {
		
	}
	// Step 3: Create accessor to access the instance
	public static  singleton_coffeevendingmachine getInstance()
	{
		return Instance_singleton_coffee_vending_machine;
	}
	public void brewAcupofCoffee()
	{
		System.out.println("A hot cup of coffee for me");
	}
}
