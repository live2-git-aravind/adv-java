package DesignPattern;

public class MultiplethreadsSingleton {

	
		//WHY?
		// SINGLETON
		//SINGLE TO N (SINGLE OBJECT WILL BE CREATED FOR AN APPLICATOIN)
		//DEVELOPER SHOULD USE ONLY ONE OBJECT
		//DEVERLOPER CANNOT CREATE THE INSTANCE ACCIDENTALLY.

			public static void main(String[] args) {
				Singelteon_CoffeVendingMachine4 singelteon_CoffeVendingMachine 
				= Singelteon_CoffeVendingMachine4.getInstance();
				singelteon_CoffeVendingMachine.brewACupOfCoffee();		
				
				//Check if only one instance is created.
				Singelteon_CoffeVendingMachine4 singelteon_CoffeVendingMachine4
				= Singelteon_CoffeVendingMachine4.getInstance();
				
				singelteon_CoffeVendingMachine4.brewACupOfCoffee();	
				System.out.println(singelteon_CoffeVendingMachine);
				System.out.println(singelteon_CoffeVendingMachine4);
				//A developer cannot create an instance
				//Singelteon_CoffeVendingMachine singelteon_CoffeVendingMachine = new Singelteon_CoffeVendingMachine();
			}
			
		}

		//HOW to construct a singleton
		class Singelteon_CoffeVendingMachine4{
			//STEP 1 : create a variable which is 1. private, 2.static,  3. final
			private static Singelteon_CoffeVendingMachine4 INSTANCE_SINGLETON_COFFEE_VENDING_MACHINE;

			//step 2: create a private constructor
			private Singelteon_CoffeVendingMachine4() {
				
			}
			//step 3: create the accessor to access the instance
			public static Singelteon_CoffeVendingMachine4 getInstance() {
				if(INSTANCE_SINGLETON_COFFEE_VENDING_MACHINE == null) {
				INSTANCE_SINGLETON_COFFEE_VENDING_MACHINE = new Singelteon_CoffeVendingMachine4();
				}
				return INSTANCE_SINGLETON_COFFEE_VENDING_MACHINE;
			}
			
			//business methods
			public void brewACupOfCoffee() {
				System.out.println("A hot cup of coffee specially brewed for Automation Engineers!");
			}
		}

