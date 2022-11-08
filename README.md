# Fraud Detection for Credit Card Transactions

(The Documentation is not yet complete.)

### Technologies used:
Big Data, AWS, Sagemaker, Elastic Beanstalk, Lambda, S3, EC2, API Gateway, EMR, Cloud
Watch, Python, Spark, Flask, Java Springboot, SQL, XGBoost, StandardWeb technologies


### Summary of the project:

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



### Project Guide:

●	CreditCardTransactionWebsite: includes the code for the User Interface development

●	DataManagerLayer: includes the code for the Data Manager Service which is the service that connects transaction service with the Preprocessing service

●	Preprocessing Micro-service: The code that preprocesses the data before passing it to the ML model for prediction

●	Model Deployment: Code for training, creating, and deploying the ML model

●	Lambda Function: The code that is used to invoke the ML Model endpoint from the API gateway service

●	Security Service: The user login code is in this folder

●	Gateway Service: This is the code for user authentication 

●	Transaction Service: Each transaction is processed in this service and sent to Data Manager Layer

●	User Service: Each new user created is handled in this service







# Table of Contents
- [1 Introduction](#1-introduction)
  - [1.1 Introduction to Problem Domain](#11-introduction-to-problem-domain)
  - [1.2 Scope and Objective of the Project](#12-scope-and-objective-of-the-project)
  - [1.3 Existing Solutions](#13-existing-solutions)
  - [1.4 Proposed Solution](#14-proposed-solution)
- [2 Background and Related Work](#2-background-and-related-work)
- [3 Technical Details](#3-technical-details)
  - [3.1 The Architecture](#31-the-architecture)
    - [3.1.1 The Overall System Design](#311-the-overall-system-design)
    - [3.1.2 Module View](#312-module-view)
    - [3.1.3 Component and Connector View](#313-component-and-connector-view)
    - [3.1.4 Allocation View](#314-allocation-view)
    - [3.1.5 Quality View](#315-quality-view)
  - [3.2 System Usage](#32-system-usage)
    - [3.2.1 Sequence Diagram](#321-sequence-diagram)
      - [3.2.1.1 User Login](#3211-user-login)
      - [3.2.1.2 User Logout](#3212-user-logout)
      - [3.2.1.3 Register a User](#3213-register-a-user)
      - [3.2.1.4 Process a Credit Card Transaction](#3214-process-a-credit-card-transaction)
  - [3.3System Requirements](#33system-requirements)
- [4 Implementation](#4-implementation)
  - [4.1 User Interface (UI)](#41-user-interface-ui)
  - [4.2 Cloud-based Services](#42-cloud-based-services)
  - [4.3 Cloud-based Data Analytics](#43-cloud-based-data-analytics)
    - [4.3.1 SageMaker](#431-sagemaker)
    - [4.3.2 XGBoost](#432-xgboost)
  - [4.4 Cloud-based Microservices](#44-cloud-based-microservices)
    - [4.4.1 Gateway Manager Endpoints](#441-gateway-manager-endpoints)
    - [4.4.2 Security Manager](#442-security-manager)
    - [4.4.3 Transaction Manager](#443-transaction-manager)
    - [4.4.4 User Manager](#444-user-manager)
    - [4.4.5 Data Layer Manager](#445-data-layer-manager)
- [5 Big Data Considerations](#5-big-data-considerations)
  - [5.1 Velocity](#51-velocity)
  - [5.2 Volume](#52-volume)
  - [5.3 Value](#53-value)
  - [5.4 Other Big data characteristics](#54-other-big-data-characteristics)
- [6 Project Plan](#6-project-plan)
  - [6.1 Time Schedule For Completion Of The Project Work](#61-time-schedule-for-completion-of-the-project-work)
- [7 Summary and Future Work](#7-summary-and-future-work)








# 1 Introduction 
## 1.1 Introduction to Problem Domain 
## 1.2 Scope and Objective of the Project 
## 1.3 Existing Solutions 
## 1.4 Proposed Solution 
# 2 Background and Related Work
# 3 Technical Details 
## 3.1 The Architecture 
### 3.1.1 The Overall System Design 
### 3.1.2 Module View 
### 3.1.3 Component and Connector View 
### 3.1.4 Allocation View 
### 3.1.5 Quality View 
## 3.2 System Usage 
### 3.2.1 Sequence Diagram 
#### 3.2.1.1 User Login 
#### 3.2.1.2 User Logout 
#### 3.2.1.3 Register a User 
#### 3.2.1.4 Process a Credit Card Transaction 
## 3.3System Requirements 
# 4 Implementation 
## 4.1 User Interface (UI) 
## 4.2 Cloud-based Services 
## 4.3 Cloud-based Data Analytics 
### 4.3.1 SageMaker 
### 4.3.2 XGBoost 
## 4.4 Cloud-based Microservices 
### 4.4.1 Gateway Manager Endpoints 
### 4.4.2 Security Manager 
### 4.4.3 Transaction Manager 
### 4.4.4 User Manager 
### 4.4.5 Data Layer Manager 
# 5 Big Data Considerations 
## 5.1 Velocity 
## 5.2 Volume 
## 5.3 Value 
## 5.4 Other Big data characteristics 
# 6 Project Plan 
## 6.1 Time Schedule For Completion Of The Project Work 
# 7 Summary and Future Work 
