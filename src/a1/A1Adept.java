package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//inputs the amount of products that are in the list

		int count = sc.nextInt();
		//The class for the products (I named it fruit because I thought salami was a fruit)

		class Fruit{
			public String name;
			public float price;
			public void setName(String name1) {
				name = name1;
			}
			public String getName() {
				return name;
			}
			public void setPrice(float price1) {
				price = price1;
			}
			public float getPrice() {
				return price;
			}
			
		}
		//class for each of the customers
		class Customer{
			public String custname;
			public float credit;
			public Customer() {
				credit = 0;
			}
			public void setCustname(String custname2) {
				custname = custname2;
			}
			public String getCustname() {
				return custname;
			}
			public void setCredit(float credit2) {
				credit = credit2 + credit;
			}
			public float getCredit() {
				return credit;
			}
		}
		//creates an array of type Fruit
		Fruit[] fruits = new Fruit[count];
		//initializes the objects in fruits
		for(int i=0;i<count;i++) {
			//String temp = sc.next();
			fruits[i] = new Fruit();
		}
		for(int i=0;i<count;i++) {
			String temp = sc.next();
			fruits[i].setName(temp);
			float temp2 = sc.nextFloat();
			fruits[i].setPrice(temp2);
			
		} 
		//inputs the amount of customers
		int count2 = sc.nextInt();
		Customer[] customers = new Customer[count2];
		//initializes the objects in customers
		for(int i=0;i<count2;i++) {
			customers[i] = new Customer();
			String first = sc.next();
			String second = sc.next();
			customers[i].setCustname(first+" "+second);
			int prodcount = sc.nextInt(); //inputs how many products each customer is getting
			for(int j=0;j<prodcount;j++) {
				int mult = sc.nextInt(); //inputs the amount of said product
				String prodname = sc.next();
				for(int k=0;k<count;k++) {
					if(fruits[k].getName().equals(prodname)) { //finds the matching element of fruits with the product name
						customers[i].setCredit(fruits[k].getPrice()*mult); //updates how much the customer spent on the product
					}
				}
			}
			
			
		}

		int max = 0;
		int min = 0;
		float mean = 0;
		for(int i=0;i<count2;i++) { //finds the min and max spender as well as calculates the mean
			if(customers[i].getCredit()>customers[max].getCredit()) {
				max = i;
			}
			if(customers[i].getCredit()<customers[min].getCredit()) {
				min = i;
			}
			mean = customers[i].getCredit() + mean;
		}
		
		mean = mean/(float)count2;
		System.out.print("Biggest: "+customers[max].getCustname()+" (");
		System.out.printf("%.2f", customers[max].getCredit());
		System.out.println(")");
		System.out.print("Smallest: "+customers[min].getCustname()+" (");
		System.out.printf("%.2f", customers[min].getCredit());
		System.out.println(")");
		System.out.print("Average: ");
		System.out.printf("%.2f",mean);
		System.out.println();
}
}
