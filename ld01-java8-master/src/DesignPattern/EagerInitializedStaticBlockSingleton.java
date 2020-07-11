package DesignPattern;

public class EagerInitializedStaticBlockSingleton {
//WHY?
// SINGLETON
//SINGLE TO N (SINGLE OBJECT WILL BE CREATED FOR AN APPLICATOIN)
//DEVELOPER SHOULD USE ONLY ONE OBJECT
//DEVERLOPER CANNOT CREATE THE INSTANCE ACCIDENTALLY.

	public static void main(String[] args) {
		System.out.println("The framework starts up!");
		try {
			Class.forName("design_patterns.Singelteon_CoffeVendingMachine2");
		} catch (ClassNotFoundException e) {
			System.out.println("Exception occured while loadeing the Singelteon_CoffeVendingMachine2");
		}
		
		Singelteon_CoffeVendingMachine2 singelteon_CoffeVendingMachine 
		= Singelteon_CoffeVendingMachine2.getInstance();
		singelteon_CoffeVendingMachine.brewACupOfCoffee();		
//		
//		//Check if only one instance is created.
//		Singelteon_CoffeVendingMachine2 singelteon_CoffeVendingMachine1
//		= Singelteon_CoffeVendingMachine2.getInstance();
//		
//		singelteon_CoffeVendingMachine1.brewACupOfCoffee();	
//		System.out.println(singelteon_CoffeVendingMachine);
//		System.out.println(singelteon_CoffeVendingMachine1);
		//A developer cannot create an instance
		//Singelteon_CoffeVendingMachine singelteon_CoffeVendingMachine = new Singelteon_CoffeVendingMachine();
	}
	
}

//HOW to construct a singleton
class Singelteon_CoffeVendingMachine2{
	//STEP 1 : create a variable which is 1. private, 2.static,  3. final
	private static  Singelteon_CoffeVendingMachine2 INSTANCE_SINGLETON_COFFEE_VENDING_MACHINE;

	//step 2: create a private constructor
	private Singelteon_CoffeVendingMachine2() {
		
	}
	//step 2.1 : add a static block to initialize and handle exceptions
	static {
		try {
			INSTANCE_SINGLETON_COFFEE_VENDING_MACHINE = new Singelteon_CoffeVendingMachine2();
			System.out.println("STATIC BLOCK EXECUTED AND INSTANCE CREATED!");
		} catch (Exception e) {
			throw new RuntimeException("ERROR CREATING AN INSTANCE OF A SINGLETON!");
		}
	}
	//step 3: create the accessor to access the instance
	public static Singelteon_CoffeVendingMachine2 getInstance() {
		return INSTANCE_SINGLETON_COFFEE_VENDING_MACHINE;
	}
	
	//business methods
	public void brewACupOfCoffee() {
		System.out.println("A hot cup of coffee specially brewed for Automation Engineers!");
	}
}