package DesignPattern;

public class ThreadSafeLazyInitializedSingleton {

	public static void main(String[] args) {
		Singelteon_CoffeVendingMachine3 singelteon_CoffeVendingMachine 
		= Singelteon_CoffeVendingMachine3.getInstance();
		singelteon_CoffeVendingMachine.brewACupOfCoffee();		
		
		//Check if only one instance is created.
		Singelteon_CoffeVendingMachine3 singelteon_CoffeVendingMachine1
		= Singelteon_CoffeVendingMachine3.getInstance();
		
		singelteon_CoffeVendingMachine1.brewACupOfCoffee();	
		System.out.println(singelteon_CoffeVendingMachine);
		System.out.println(singelteon_CoffeVendingMachine1);
		//A developer cannot create an instance
		//Singelteon_CoffeVendingMachine singelteon_CoffeVendingMachine = new Singelteon_CoffeVendingMachine();
	}
	
}

//HOW to construct a singleton
class Singelteon_CoffeVendingMachine3{
	//STEP 1 : create a variable which is 1. private, 2.static,  3. final
	private static Singelteon_CoffeVendingMachine3 INSTANCE_SINGLETON_COFFEE_VENDING_MACHINE;

	//step 2: create a private constructor
	private Singelteon_CoffeVendingMachine3() {
		
	}
	//step 3: create the accessor to access the instance and ensure that it is thread safe
	public static synchronized Singelteon_CoffeVendingMachine3 getInstance() {
		if(INSTANCE_SINGLETON_COFFEE_VENDING_MACHINE == null) {
		INSTANCE_SINGLETON_COFFEE_VENDING_MACHINE = new Singelteon_CoffeVendingMachine3();
		}
		return INSTANCE_SINGLETON_COFFEE_VENDING_MACHINE;
	}
	
	//business methods
	public void brewACupOfCoffee() {
		System.out.println("A hot cup of coffee specially brewed for Automation Engineers!");
	}
}
