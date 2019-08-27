package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int CustCount = scan.nextInt(); //how many customers
		for(int i=0;i<CustCount;i++) {
			float sum = 0;
			String CustName1 = scan.next();
			//System.out.println(CustName1);
			char[] CustName = CustName1.toCharArray(); //converts the customer's name to an array
			String CustName2 = scan.next();
			int items = scan.nextInt();
			//System.out.println(items);
			//calculates how much a customer bought
			for(int j=0;j<items;j++) {
				float multiples = scan.nextFloat();
				//System.out.println(multiples);
				String product = scan.next();
				float price = scan.nextFloat();
				sum = multiples*price + sum;
			}
			System.out.print(CustName[0]+". "+ CustName2+": ");
			System.out.printf("%.2f", sum); //outputs customer's total
			System.out.println();
		}
		// Your code follows here.
		
	}
}
