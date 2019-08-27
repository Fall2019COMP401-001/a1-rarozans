package a1;

import java.util.ArrayList;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//inputs the amount of products that are in the list
		int count = sc.nextInt();
		//The class for the products (I named it fruit because I thought salami was a fruit)
		class Fruit{
			public String name;
			public float price;
			public int purchase; //tracks how many times each product was purchased
			//public int cust;
			public ArrayList<String> cust = new ArrayList<String>(); //tracks who bought what

			public Fruit() {
				purchase = 0;
				//cust = 0;
			}
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
			public void setPurchase(int purchase2) {
				purchase = purchase + purchase2;
			}
			public int getPurchase() {
				return purchase;
			}
			public void setCust(String cust1) {
				cust.add(cust1); //adds the name of each customer
			}
			//the function returns how many customers bought a certain item
			public int uniquelist() {
				int temp=0;
				for(int r=0;r<cust.size()-1;r++) {
					if(cust.get(r).equals(cust.get(r+1))!=true){
						temp++;
					}
				}
				return temp;
			}
		}
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
			public void setCredit(float credit2) { //updates how much a customer spent
				credit = credit2 + credit;
			}
			public float getCredit() {
				return credit;
			}
		}
		
		Fruit[] fruits = new Fruit[count]; //makes an array of type Fruit
		
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
		int count2 = sc.nextInt();
		Customer[] customers = new Customer[count2];
		for(int i=0;i<count2;i++) {
			//int current = -1;
			customers[i] = new Customer();
			String first = sc.next();
			String second = sc.next();
			customers[i].setCustname(first+" "+second); //concatenates first and last name
			int prodcount = sc.nextInt(); //inputs how many products the customer is getting
			for(int j=0;j<prodcount;j++) {
				int mult = sc.nextInt(); //inputs the amount of a certain product a customer is getting
				String prodname = sc.next();
				for(int k=0;k<count;k++) {
					if(fruits[k].getName().equals(prodname)) { //finds the matching product in the Fruit array
						//System.out.println(prodname+"ayo");
						customers[i].setCredit(fruits[k].getPrice()*mult); //returns price of matched product
						fruits[k].setPurchase(mult); //updates how much of a certain product was purchased
						fruits[k].setCust(customers[i].getCustname()); //updates what customer bought the product in the arraylist
						
					}
				}
			}
			
			
		}
		//returns how much of each product was purchased
		for(int i=0;i<count;i++) {
			if(fruits[i].getPurchase()!=0) {
				System.out.println((fruits[i].uniquelist()+1)+" customers bought "+fruits[i].getPurchase()+" "+(fruits[i].getName()));
			}
			else {
				System.out.println("No customers bought "+fruits[i].getName());
			}
		}
		
	}
}
