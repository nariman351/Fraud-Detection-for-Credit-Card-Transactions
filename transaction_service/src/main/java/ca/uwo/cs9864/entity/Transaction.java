package ca.uwo.cs9864.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {

	// What are the transaction attributes? 
	
	// Transaction ID (ID, AutoIncrement)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tid; 
	
	// Analytics Result
	@Column(name = "analytics_approved")
	private boolean analyticsApproved; 
	
	////////////////////////////
	// Required JSON Attributes
	////////////////////////////
	
	
	// Username
	@Column(name = "username")
	private String username;
	
	// cc number
	@Column(name = "cc_number")
	private long ccNumber;
	
	// cc exp month
	@Column(name = "cc_exp_month")
	private int expMonth;
	
	// cc exp year
	@Column(name = "cc_exp_year")
	private int expYear;
	
	// Amount
	@Column(name ="amount")
	private double amount;
	
	/* Following attribute data should be in Kaggle dataset format */ 
	
	// transaction year
	private int tranYear;
	
	// transaction month
	private int tranMonth;
	
	// transaction day
	private int tranDay;
	
	// transaction time
	private String tranTime;
	
	// Parameterized Constructor
	public Transaction(String username, long ccNumber, int expMonth, int expYear, double amount) {
		
		this.username = username;
		this.ccNumber = ccNumber; 
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.amount = amount;

	}
	
	// Default Constructor
	public Transaction() {
		
	}
	
	/////////////////////////
	//	PrePersist Methods
	/////////////////////////
	
	// Method: Pre Persist all the required values in the entity 
	@PrePersist
	public void prePersistTranYear() {
	
		LocalTime colonTime = LocalTime.now();
		LocalDate calender = LocalDate.now();
		
		String timeColonPattern = "HH:mm";
		DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern(timeColonPattern);
		
		this.tranYear = calender.getYear();
		this.tranMonth = calender.getMonth().getValue();
		this.tranDay = calender.getDayOfMonth();
		
		this.tranTime = timeColonFormatter.format(colonTime);
		
	}

	@Column(nullable = false)
	public int getTranYear() {
		return tranYear;
	}
	
	@Column(nullable = false)
	public int getTranMonth() {
		return tranMonth;
	}
	
	@Column(nullable = false)
	public int getTranDay() {
		return tranDay;
	}
	
	@Column(nullable = false)
	public String getTranTime() {
		return tranTime;
	}
	
	/////////////////////////
	//	Getters and Setters
	/////////////////////////

	public void setTranYear(int tranYear) {
		this.tranYear = tranYear;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(long ccNumber) {
		this.ccNumber = ccNumber;
	}

	public int getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setTranMonth(int tranMonth) {
		this.tranMonth = tranMonth;
	}

	public void setTranDay(int tranDay) {
		this.tranDay = tranDay;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}

	public boolean isAnalyticsApproved() {
		return analyticsApproved;
	}

	public void setAnalyticsApproved(boolean analyticsApproved) {
		this.analyticsApproved = analyticsApproved;
	}
	
	
}
