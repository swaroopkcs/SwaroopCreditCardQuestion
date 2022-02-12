package creditAndDebitAssignment;

public class PaymentOption {
	private String cardNumber;
	private int pin;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	boolean checkForDetails(String cardNoEntered, int pinEntered) {
		if (cardNoEntered.equals(cardNumber) && pinEntered == pin) {
			return true;
		} else {
			return false;
		}

	}

}
