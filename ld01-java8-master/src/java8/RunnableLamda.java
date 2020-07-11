package java8;

public class RunnableLamda {
public static void main(String[] args) {
	//usingThreadclass();
	//usingRunnable();
	//anonymousClass();	
   // UsingThreadLamda();
    runnablelambda();
    
}


private static void runnablelambda() {
	Runnable runnablelamda = ()->System.out.println("RunnableLambdaExpression");
    Thread thread = new Thread(runnablelamda);
    thread.start();
}


private static void UsingThreadLamda() {
	new Thread(() -> System.out.println("ThreadLambdaExpression")).start();
}		


private static void anonymousClass() {
	new Thread() {
		@Override
		public void run() {
			System.out.println("Anonymous class using Lambda Expression");
		}	
		}.start();
}


private static void usingRunnable() {
	TestThreadRunnable testThreadRunnable=new TestThreadRunnable();
	Thread thread = new Thread(testThreadRunnable);
	thread.start();
}


private static void usingThreadclass() {
	String threadnameString= Thread.currentThread().getName();
	System.out.println(threadnameString);
	System.out.println(Thread.currentThread().getId());
	TestThread testThread = new TestThread();
	testThread.start();
}
}

class TestThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread.currentThread().setName("Child Thread Renamed");
		System.out.println("Child Thread : TestThread run()");
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
	}
}

class TestThreadRunnable implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Implementing Runnable.....");
	} 
	
}
