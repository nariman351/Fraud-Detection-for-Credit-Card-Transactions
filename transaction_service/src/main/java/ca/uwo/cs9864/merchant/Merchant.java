package ca.uwo.cs9864.merchant;

// Class: Merchant Information
public class Merchant {

	// Merchant name (constant)
	private String merchantName;
	
	// Merchant city (constant)
	private String merchantCity;

	// Merchant state (constant)
	private String merchantState;
	
	// MCC (constant)
	private int merchantMCC;
	
	// Use chip (constant)
	private String chipUse; 
	
	public Merchant() {
		
		this.merchantName = "ABC Corporation";
		this.merchantCity = "ONLINE";
		this.merchantState = "NY";
		this.merchantMCC = 1234;
		this.chipUse = "Online Transaction";				
	}

	///////////////////
	// Setters/Getters
	///////////////////
	
	public String getMerchantName() {
		return merchantName;
	}

	public String getMerchantCity() {
		return merchantCity;
	}

	public String getMerchantState() {
		return merchantState;
	}

	public int getMerchantMCC() {
		return merchantMCC;
	}

	public String getChipUse() {
		return chipUse;
	}

}
