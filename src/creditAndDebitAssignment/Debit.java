package creditAndDebitAssignment;

public class Debit extends PaymentOption {
	private double balance = 7589.51;

	public Debit() {
		super();
	}

	public String checkForBalance(double billAmount) {
		if (billAmount <= balance) {
			double availableRemaining = balance - billAmount;
			return "Transaction Approved. Thank you for the payment. Your remaining available amount is: "
					+ availableRemaining;
		}
		return "Transaction failed. Please check your available balance";
	}

}
