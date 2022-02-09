package creditAndDebitAssignment;

public class Credit extends PaymentOption{
	private int creditLimit;
	private double balanceUsed;
	String displayAvailableCredit;
	public Credit(int creditLimit, double balanceUsed) {
		super();
		this.creditLimit = creditLimit;
		this.balanceUsed = balanceUsed;
	}
	public String checkForAvailableCredit(double billAmount) {
		if(billAmount<=(creditLimit-balanceUsed)) {
			double availableRemaining = creditLimit-balanceUsed-billAmount;
			return "Transaction Approved. Thank you for the payment. Your remaining available amount is: "+availableRemaining;
		}
		return "Transaction failed. Please check your available credit";
	}
	

}
