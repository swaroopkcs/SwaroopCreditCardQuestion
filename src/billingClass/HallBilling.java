package billingClass;

import java.util.Scanner;

public class HallBilling {
	public void billing() {
	System.out.println("Welcome to banquet hall");
	Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of Guests");
		int numOfGuests = sc.nextInt();
		// Setting the values for tax for food as 15% and beverages as 18%
		Banquet banquet = new Banquet(15.0, 18.0);
		if (numOfGuests >= 10 && numOfGuests <= 500) {
			banquet.setNumOfGuests(numOfGuests);
			// Assigning the values for the variables in Banquet Class
			System.out.println("Please enter the base cost for the banquet: ");
			banquet.baseBookingCost = sc.nextDouble();
			if (banquet.baseBookingCost >= 100) {
				System.out.println("Please enter the cost of food per person: ");
				banquet.costOfFood = sc.nextDouble();
				if (banquet.costOfFood > 0) {
					System.out.println("Please enter the cost of beverages per person: ");
					banquet.costOfBeverage = sc.nextDouble();
					if (banquet.costOfBeverage > 0) {
						System.out.println("Please enter the tip percentage: ");
						banquet.tip = sc.nextDouble();
						if (banquet.tip >= 5) {
							// calculating the base cost from the values entered
							double baseCost = banquet.calculateBaseCost(banquet.baseBookingCost, banquet.costOfFood,
									banquet.costOfBeverage, banquet.tip, numOfGuests);
							banquet.setBaseCost(baseCost);
//							double taxAmount = banquet.calculateTax(baseCost);
//							double cess = banquet.calculateCess(numOfGuests, baseCost);
//							System.out.println("The base cost without tax:       " + baseCost);
//							System.out.println("Tax applied at 18%:              " + taxAmount);
//							System.out.println("Cess Applied:                    " + cess);
//							banquet.calcuateTheTotalCost(baseCost, taxAmount, cess);
							banquet.calcuateTheTotalCost();

						} else {
							System.out.println("Please provide a minimum tip of 5%");
						}
					} else {
						System.out.println("Beverage Cost cannot be 0. Please provide the Bevarage Cost");
					}
				} else {
					System.out.println("Cost of food cannot be zero. Please provide the cost of food");
				}
			} else {
				System.out.println("Sorry the minumum Base cost required is $100");
			}
		} else {
			System.out.println(
					"Sorry The minimum number of guests permitted is 10 and the maximum number permitted is 500");
		}
		sc.close();
	}

}
