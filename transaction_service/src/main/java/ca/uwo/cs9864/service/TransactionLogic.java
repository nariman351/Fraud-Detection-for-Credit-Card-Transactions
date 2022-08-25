package ca.uwo.cs9864.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import ca.uwo.cs9864.entity.Transaction;
import ca.uwo.cs9864.exceptions.ResourceNotFoundException;
import ca.uwo.cs9864.merchant.Merchant;
import ca.uwo.cs9864.paymentprocessor.PaymentProcessor;
import ca.uwo.cs9864.repository.TransactionRepository;

// Class: Service logic
public class TransactionLogic {

	// HTTP Handler
	private HTTPHandler httpHandler;
	
	// Merchant 
	private Merchant merchant;
	
	// Payment processor
	private PaymentProcessor paymentProcessor;
	
	// Constructor
	public TransactionLogic() {
	
		//Initializations
		this.paymentProcessor = PaymentProcessor.getInstance();
		this.merchant = new Merchant();
		this.httpHandler = new HTTPHandler();
	}
	
	/////////////////////////
	//	Public Methods
	/////////////////////////
	
	// Method: Process the received transaction and send the result back
	// Successful: true
	// Unsuccessful: false
	public boolean process(Transaction transaction) {
		
		// Process transaction with both payment processor for traditional processing and 
		// with Analytics service for extra scrutiny
		
		Object ppResult = this.getPaymentProcessorResult(transaction);
		Object analyticsResult = this.getAnalyticsResult(transaction); 
		
		if (ppResult != null && analyticsResult != null) {
			
			// Use Case: Ban the user 
				// If the Analytics results are false for X amounts of transaction
			
			// Use Case: Analytics approved the transaction
			if ((ppResult instanceof Boolean) && (analyticsResult instanceof Boolean)) {
		
				// If both PP and AS approves the transaction
				if ( ((boolean) ppResult) && ( (boolean) analyticsResult) ) {
					
					// Approve the transaction
					return true;
				}
			}
		}
		
		// Decline the transaction
		return false;
	}

	/////////////////////////
	//	Private Methods
	/////////////////////////
	
	// Method: Get Payment Processor's Result
	private Object getPaymentProcessorResult(Transaction transaction) {
		
		// Process the payment and send the result back
		// For demo purpose, we have intentionally left the postal code parameter empty
		return this.getPaymentProcessor().processCreditCard(transaction.getCcNumber(), transaction.getExpMonth(), transaction.getExpYear(), "");
	}
	
	// Method: Get Analytics results
	private Object getAnalyticsResult(Transaction transaction) {
		
		// Build JSON for the transaction
		JSONObject json = this.buildJSON(transaction);
		
		// Send JSON to Data Layer Manager for Analytics processing
		Object result = null;
				
		if (json != null) {
		
			result = this.getHttpHandler().httpSendRequest(json, "POST");
		}
		
		
		// Check if the result is not null
		if (result != null) {
			
			// Check if result is of type Boolean
			if (result instanceof Boolean) {
				
				return (boolean) result;
			}
		} 
		
		// Send the default result back
		return null;
	}
	
	// Method: Build required transaction JSON
	private JSONObject buildJSON(Transaction transaction) {
		
		// JSON for Analytics
		JSONObject json = new JSONObject();
		
		// Required fields for analytics
		long cardNumber;
		String postalCode;
		String merchantState;
		int merchantMCC;
		String useChip;
		int tranDay;
		int tranMonth;
		int tranYear;
		String tranTime;
		double tranAmount;
		
		// Get user info from User Manager using username and HTTP method GET
		JSONObject userInfo = (JSONObject) this.getHttpHandler().httpGETRequest(transaction.getUsername(), "GET");
		
		if (userInfo != null) {
			
			cardNumber = transaction.getCcNumber();
			postalCode = (String) userInfo.get("postalCode");
			merchantState = this.getMerchant().getMerchantState();
			merchantMCC = this.getMerchant().getMerchantMCC();
			useChip = this.getMerchant().getChipUse();
			tranDay = transaction.getTranDay();
			tranMonth = transaction.getTranMonth();
			tranYear = transaction.getTranYear();
			tranTime = transaction.getTranTime();
			tranAmount = transaction.getAmount();
		
			// Build JSON
			json.put("card_number", cardNumber);
			json.put("postal_code", postalCode);
			json.put("merchant_state", merchantState);
			json.put("merchant_MCC", merchantMCC);
			json.put("use_chip", useChip);
			json.put("transaction_day", tranDay);
			json.put("transaction_month", tranMonth);
			json.put("transaction_year", tranYear);
			json.put("transaction_time", tranTime);
			json.put("transaction_amount", tranAmount);
		}
		
		return json;
	}
	
	/////////////////////////
	//	Getters and Setters
	/////////////////////////

	private HTTPHandler getHttpHandler() {
		return this.httpHandler;
	}

	private Merchant getMerchant() {
		return this.merchant;
	}

	private PaymentProcessor getPaymentProcessor() {
		return this.paymentProcessor;
	}
}
