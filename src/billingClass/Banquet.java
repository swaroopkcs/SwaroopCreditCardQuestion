package billingClass;

public class Banquet {
	double baseBookingCost;
	double costOfFood;
	double taxOnFood;
	double costOfBeverage;
	double taxOnBeverage;
	double tip;
	double baseCost;
	int numOfGuests;

	//Setting the values for tax on food and beverages from HallBilling Class
	public Banquet(double taxOnFood, double taxOnBeverage) {
		this.taxOnFood = taxOnFood;
		this.taxOnBeverage = taxOnBeverage;
	}
	public int getNumOfGuests() {
		return numOfGuests;
	}
	public void setNumOfGuests(int numOfGuests) {
		this.numOfGuests = numOfGuests;
	}


	double calculateBaseCost(double bookingBaseCost, double foodCost, double beverageCost, double tipPerc, int numOfGuests) {
		//calculating the base cost without tip per person
		double baseCostWoTip = bookingBaseCost + ((foodCost*(100+taxOnFood)/100) + (beverageCost*(100+taxOnBeverage)/100)*this.numOfGuests);
		double tipAmount = baseCostWoTip * tipPerc / 100;
		//base cost with tip
		double baseCost = baseCostWoTip + tipAmount;
		return baseCost;
	}

	public double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}

	private double calculateTax() {
		// Assuming the tax on banquet halls as 18%. Assuming tax applied on base cost per person
		double taxApplied = baseCost * 18 / 100;
		return taxApplied;
	}

	private double calculateCess() {
		//bill before tax taken as the total base cost per person
		double serviceCess = 0;
		double cessPerc = 0;
		if (numOfGuests <= 40) {
			cessPerc = 4;
		} else if (numOfGuests > 40 && numOfGuests <= 80) {
			cessPerc = 8;
		} else if (numOfGuests > 80 && numOfGuests < 150) {
			cessPerc = 10;
		} else {
			cessPerc = 12.5;
		}
		serviceCess = baseCost * cessPerc / 100;
		return serviceCess;
	}
	void calcuateTheTotalCost() {
		//calculating the total base cost and calculating the price for the whole group
		double totalCost = (baseCost+calculateTax()+calculateCess());
		System.out.println("******************Your Reciept*********************");
		System.out.println("Base Cost:                      "+baseCost);
		System.out.println("(including food and beverages)");
		System.out.println("Tax applied at 18%:             "+calculateTax());
		System.out.println("Cess applied:                   "+calculateCess());
		System.out.println("The total cost will be:         "+totalCost);
		System.out.println("***************************************************");
		System.out.println("Thank you for visiting us. Please come again.");
	}

}
