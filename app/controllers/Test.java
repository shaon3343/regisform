package controllers;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String shoikat = "Shaon,Shoikat,Sultan,Bandladesh";
		
		String array[]=shoikat.split(",");
		
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]+", ");

	}

}
