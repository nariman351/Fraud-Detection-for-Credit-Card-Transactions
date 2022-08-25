package ca.uwo.cs9864.paymentprocessor;

// Class: Mimic 3rd party payment processor activities
// Class Type: Singleton
public class PaymentProcessor {

	// Singleton class attribute
	private static PaymentProcessor instance;
	
	private PaymentProcessor() {
		
	}
	
	public static PaymentProcessor getInstance() {
		
		if (instance != null) {
			
			return instance; 
		}
		else {
			
			instance = new PaymentProcessor();
			
			return instance;
		}
	}
	
	
	// Public Methods
	
	// Method: Charge the credit card, if it has funds 
	public boolean processCreditCard(long ccNumber, int ccExpMonth, int ccExpYear, String billingPostalCode) {
		
		// Payment processor will contact the bank, and if credit card has funds and postal code matches, 
		// credit card will be charged and method would return true. 
		
		// We will only mimic the payment processor and bank activities by returning "true" for 
		// every transaction.
		return true;
	}
}
