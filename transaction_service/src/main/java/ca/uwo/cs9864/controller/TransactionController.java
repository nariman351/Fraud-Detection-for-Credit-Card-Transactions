package ca.uwo.cs9864.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.uwo.cs9864.entity.Transaction;
import ca.uwo.cs9864.exceptions.ResourceNotFoundException;
import ca.uwo.cs9864.repository.TransactionRepository;
import ca.uwo.cs9864.service.TransactionLogic;

//Controller class for users
@RestController
@RequestMapping("/TransactionManager")
public class TransactionController {
	
	// Repository
	@Autowired
	private TransactionRepository transactionRepository;
	
	// Business Logic
	TransactionLogic transactionLogic = new TransactionLogic();

	/////////////
	// Endpoints
	/////////////
	
	// Process transaction
	@PostMapping("/processTransaction")
	public boolean processTransaction(@RequestBody Transaction transaction) {
		
		// Register the transaction into DB
		this.transactionRepository.save(transaction);
		
		// Process the transaction
		boolean result = this.transactionLogic.process(transaction);
		
		// Save the analytics result in transaction
		this.saveAnalyticsResult(result, transaction);
		
		// Send the result back
		return result;
	}
	
	// Method: Save analytics result in the database
	private void saveAnalyticsResult(boolean result, Transaction transaction) {
		
		Transaction ext = this.transactionRepository.findById(transaction.getTid()).
				orElseThrow(() -> new ResourceNotFoundException("TID: " + transaction.getTid() + " not found!"));
		
		// If the transaction already exist in the db,
		// update the analytics result
		if (ext != null) {
			
			// Set the analytics results in existing transaction
			ext.setAnalyticsApproved(result);
			
			// Save
			this.transactionRepository.save(ext);
		}
	}
	
}
