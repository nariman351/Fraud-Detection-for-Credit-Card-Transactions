●	CreditCardTransactionWebsite: includes the code for the User Interface development
●	DataManagerLayer: includes the code for the Data Manager Service which is the service that connects transaction service with the Preprocessing service
●	Preprocessing Micro-service: The code that preprocesses the data before passing it to the ML model for prediction
●	Model Deployment: Code for training, creating, and deploying the ML model
●	Lambda Function: The code that is used to invoke the ML Model endpoint from the API gateway service
●	Security Service: The user login code is in this folder
●	Gateway Service: This is the code for user authentication 
●	Transaction Service: Each transaction is processed in this service and sent to Data Manager Layer
●	User Service: Each new user created is handled in this service
