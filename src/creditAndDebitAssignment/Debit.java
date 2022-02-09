package creditAndDebitAssignment;

public class Debit extends PaymentOption {
	private double balance;

	public Debit(double balance) {
		super();
		this.balance = balance;
	}
	public String checkForBalance(double billAmount) {
		if(billAmount<=balance) {
			double availableRemaining = balance-billAmount;
			return "Transaction Approved. Thank you for the payment. Your remaining available amount is: "+availableRemaining;
		}
		return "Transaction failed. Please check your available balance";
	}

}
