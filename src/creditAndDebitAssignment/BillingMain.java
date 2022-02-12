package creditAndDebitAssignment;

import java.util.Scanner;

//Application to show the Bill for a customer and ask for payment.
//Considering a hypothetical bill for the customer
public class BillingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// Initializing values for card number, pin, credit limit, balance for credit
		// and debit cards
		double unitPrice = 0.0;
		Credit credit = new Credit();
		Debit debit = new Debit();
		credit.setCardNumber("1234567890123456");
		credit.setPin(4567);
		debit.setCardNumber("4567123890123456");
		debit.setPin(7890);
		System.out.println("Welcome to Pizza Place.");
		System.out.println("We offer Cheeze Pizza on 3 sizes. Small - 5.99, Medium - 7.99 and Large - 10.99");
		System.out.println("Please enter the type of Pizza that you need");
		String pizzaChoice = sc.next();
		System.out.println("Please enter the number of " + pizzaChoice + " pizza you need:");
		int numOfPizza = sc.nextInt();
		switch (pizzaChoice) {
		case "Small":
			unitPrice = 5.99;
			break;
		case "Medium":
			unitPrice = 7.99;
			break;
		case "Large":
			unitPrice = 10.99;
			break;
		default:
			System.out.println("Please enter a valid size");
		}
		double totalPrice = unitPrice*numOfPizza;
		System.out.println("******************Your Reciept*********************");
		System.out.println("Base Cost:                      " + "$ "+totalPrice);
		System.out.println("Tax applied at 15%:             " + "$ "+(totalPrice*0.15));
//		System.out.println("Cess applied at 4%:             " + "$63.53");
		double billAmount = totalPrice*1.15;
		System.out.println("The total cost will be:         " + "$ "+billAmount);
//		System.out.println("***************************************************");
//		double billAmount = 1937.63;
		String continueChoice = "";
		do {
			System.out.println("Please select how you want to pay: Press 1 for credit " + "& Press 2 for Debit");
			int choice = sc.nextInt();
			if (choice == 1 || choice == 2) {
				System.out.println("Please enter the amount that you want to pay.");
				double billEntered = sc.nextDouble();
				if (billAmount == billEntered) {
					System.out.println("Please enter your card number.");
					String cardNoEntered = sc.next();
					System.out.println("Please enter your PIN.");
					int pinEntered = sc.nextInt();
					if (choice == 1) {
						if (credit.checkForDetails(cardNoEntered, pinEntered)) {
							System.out.println(credit.checkForAvailableCredit(billEntered));
							break;
						} else {
							System.out.println("The card number or the PIN Number entered is incorrect.");
							System.out.println("Please press Y if you want to start over.");
							continueChoice = sc.next();
						}
					} else if (choice == 2) {
						if (debit.checkForDetails(cardNoEntered, pinEntered)) {
							System.out.println(debit.checkForBalance(billEntered));
							break;
						} else {
							System.out.println("The card number or the PIN Number entered is incorrect.");
							System.out.println("Please press Y if you want to start over.");
							continueChoice = sc.next();
						}
					}

				} else {
					System.out.println("Please enter the correct bill amount");
					System.out.println("Please press Y if you want to start over.");
					continueChoice = sc.next();
				}
			} else {
				System.out.println("Please enter a valid choice");
				System.out.println("Please press Y if you want to start over.");
				continueChoice = sc.next();
			}
		} while (continueChoice.equals("Y") || continueChoice.equals("y"));
		System.out.println("Thank you for using the application");
		sc.close();
	}
}
