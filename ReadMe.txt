#Fraud Detection for Credit Card Transactions


(The Documentation is not yet complete.)

Technologies used:
Big Data, AWS, Sagemaker, Elastic Beanstalk, Lambda, S3, EC2, API Gateway, EMR, Cloud
Watch, Python, Spark, Flask, Java Springboot, SQL, XGBoost, StandardWeb technologies


Summary:
• Collaborated with a small team of 4 to design, program, and integrate
multiple services and micro-services for credit card fraud detection using
cloud based big data analytics and AIOps.
• Worked with S3, EMR, Sagemaker and Spark to create and train a production
level XGBoost Model to detect fraudulent transactions.
• Programmed a preprocessing micro-service using Flask and Elastic Beanstalk
to handle client-side data preprocessing. Integrated other services to
Data Analytics services using AWS Lambda serverless function and API
Gateway.
• The completed system was capable of preforming transactions with a
web UI while detecting fraudulent credit card transactions under 300
milliseconds with the accuracy of 85 percent.





●	CreditCardTransactionWebsite: includes the code for the User Interface development
●	DataManagerLayer: includes the code for the Data Manager Service which is the service that connects transaction service with the Preprocessing service
●	Preprocessing Micro-service: The code that preprocesses the data before passing it to the ML model for prediction
●	Model Deployment: Code for training, creating, and deploying the ML model
●	Lambda Function: The code that is used to invoke the ML Model endpoint from the API gateway service
●	Security Service: The user login code is in this folder
●	Gateway Service: This is the code for user authentication 
●	Transaction Service: Each transaction is processed in this service and sent to Data Manager Layer
●	User Service: Each new user created is handled in this service
