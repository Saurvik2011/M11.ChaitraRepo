package practice;

public class GenericMethodPractice {
	
	public static void main(String[] args) { //test script //Caller Function
		
//		int a = 10;
//		int b = 20;
//		 
//		int c = a+b;
//		System.out.println(c);
		
		int sum = add(10,20);
		System.out.println(sum);
		
		add(100,30);
		add(90,87);
		add(30,56);
	}
	                    //Parameterisation - 1
	public static int add(int a, int b) // Called method/function - generic/reusable
	{
		 
		int c = a+b;
		return c;
		//return the output to Caller - 2
	}

}
