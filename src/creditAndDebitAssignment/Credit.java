package creditAndDebitAssignment;

public class Credit extends PaymentOption {
	private int creditLimit = 4000;
	private double balanceUsed = 1200.51;
	String displayAvailableCredit;

	public Credit() {
		super();
	}

	public String checkForAvailableCredit(double billAmount) {
		if (billAmount <= (creditLimit - balanceUsed)) {
			double availableRemaining = creditLimit - balanceUsed - billAmount;
			return "Transaction Approved. Thank you for the payment. Your remaining available amount is: "
					+ availableRemaining;
		}
		return "Transaction failed. Please check your available credit";
	}

}
