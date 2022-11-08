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


Credit Card Fraud detection using cloud-based big data analytics and
AIOps comprises 3 main things, Data Analytics, Cloud Services, and Big
data.
The overall objective of this project is to deal with the data generated from
credit card transactions and use that data for analyzing the trends in the
transaction leveraging the cloud services. We primarily focused on the
volume aspect of the data due to the limitations of the cloud usage. The
credit card transaction, on the other hand, contains the Volume, Velocity, and Value components of Big data in the real world. Based on the analytics
on transaction history, we can uncover suspicious activity and perform
appropriate Identity and Access Management (IAM) actions as per the
business requirements. The results of the analytics will be integrated with
the transaction service of the system. Based on the analytics result and the
traditional transaction service result, the system decides whether the
transaction has to be approved or declined.


## 1.1 Introduction to Problem Domain 


Credit card fraud is when someone uses another person's credit card or
account information to make unauthorized purchases. “Fraud detection is a
set of activities that are taken to prevent money from being obtained through
false pretenses.”

There are multiple challenges to fraud detection:
* Need to gather historical transaction data
* Handle real-time transactions
* Security of the transactional data


## 1.2 Scope and Objective of the Project 


The objective of the project is the develop multiple services that mimic the credit
card transaction phases and each of these services are deployed in the AWS cloud
to leverage the features offered by AWS in handling the huge historical dataset
considered in the model training.
Credit Card Fraud Detection with Machine Learning is a method that involves
investigating data and developing a model that will uncover and prevent
fraudulent transactions. This is accomplished by combining all relevant aspects
of the cardholder’s transactions, such as the date, user zone, amount, provider,
client's behavioral patterns, and so on. The data is then fed into a model that has
been gradually taught to look for patterns and rules to determine if a
transaction is fraudulent or not.


## 1.3 Existing Solutions 


The traditional way of fraud detection without data analytics:
In the traditional way, the number of people using credit cards on a daily basis
was comparatively less and the transactions were manageable.
Earlier before the transaction was processed the banking sector used to verify
the transaction seemed to deviate from the usual transaction pattern with
complete manpower indulged in analyzing these patterns.
In this way, the banking firm had to consistently engage themselves in
analyzing each transaction and cross-verifying with the account holder if the
the transaction was actually initiated by them.

Conventional Fraud Detection:

● The rules of making a decision on determining schemes should be set
manually.

● Takes an enormous amount of time

● Multiple verification methods are needed; thus, inconvenient for the user

● Finds only obvious fraud activities


## 1.4 Proposed Solution 


Analytics need not replace what you’re already doing it can be an extra layer
to enhance and extend existing efforts.
Unsupervised or non-rules-based analyses driven by analytics technology
can uncover new patterns, trends, fraudulent schemes, and scenarios that
traditional approaches miss.
Detecting fraud is part of a process that starts even before you begin to
analyze data. More often than not, there will be a high number of anomalies
from the data analytics process, with very few actually being errors and even
fewer being actual fraudulent transactions.
But with professional judgment and some intuition (based on experience with
an organization), data analytics will make the process faster, more focused,
and easier.
In the modern data analytical forum, the initial manpower induced in engaging
themselves in tracking the anomalies is reduced.
Now as credit cards usage has grown, the data generated by them has also
increased constituting large volumes of data that can be used to analyze that
3
data and automate the prediction of anomalies when there is a deviation in
the transaction pattern.
When the analytic model predicts that there is an anomaly then the system
can automatically hold on to the transaction and process it only when the
the transaction is verified by the account holders.

Machine Learning-based Fraud Detection:

● Detecting fraud automatically

● Real-time streaming

● Less time needed for verification methods

● Identifying hidden correlations in data


# 2 Background and Related Work


In reference1, the authors have worked on a data set including 2 days of
transactions of a bank in Europe. This data set includes 31 columns including
the time and amount of the transaction and whether it was a fraudulent one or not. In
the first stage, the data set has been preprocessed by normalizing, and then
machine learning algorithms have been used to detect anomalous activities such as
fraudulent transactions. The algorithms used in this article are the local outlier factor
and isolation forest algorithm. In order to test the algorithm easier a 10 percent
fraction of the data set has been used.

These algorithms have reached a very
high accuracy, although the precision was not as high as expected. One of the
main reasons that the accuracy is more than 90 percent while the precision is
remarkably lower (about 30 percent), is that there is a huge imbalance between
classes and the number of fraudulent transactions is considerably lower than
genuine transactions. Another problem regarding developing an algorithm that
could detect credit card fraud is the lack of rich datasets. Banks refuse to cooperate
in sharing information for many reasons including violating users’ safety and
market competition. Because users' spending styles could change over time, to
achieve an accurate algorithm the model should be trained with up-to-date data
occasionally, which needs constant communication with the bank to get the newest
information about users.

In reference 2 the authors have used different machine-learning approaches such
as prediction, clustering, regression, classification, and evolutionary 
algorithms that have been deployed and compared in this article are genetic
algorithm, random forest, decision tree, SVM, Naïve Bayes, Bayesian Belief,
KNN, logistic regression, linear regression, RNN, LSTM, CNN, ANN, and fuzzy
clustering. The most significant solutions proposed in this paper are as follows:
Bayesian Network classifiers have performed better than other classifiers
considering precision and recall. ANN algorithms tend to detect fraud faster than
Bayesian; however, the Bayesian approach detects up to 80 percent more fraudulent
transactions. Random Forest Decision Tree shows better performance than
Logistic Regression and Decision Trees when comparing precision and accuracy.
Decision trees worked better than SVM in terms of accuracy. CNN approaches
outperformed the neural networks.

One of the important problems regarding fraud detection that has been
mentioned in this paper was that all these models would work well when they
tried to detect a fraudulent transaction that happened before but not one that is
going to happen. Another problem is that all these models work well on a specific
dataset and cannot be used on another one to predict fraudulent transactions.

------

1. Credit Card Fraud Detection using Machine Learning Algorithms, Vaishnavi Nath Dornadulaa*, Geetha
Sa, INTERNATIONAL CONFERENCE ON RECENT TRENDS IN ADVANCED COMPUTING
2019, ICRTAC 2019

2. CREDIT CARD FRAUD DETECTION USING MACHINE LEARNING:A STUDY,Pooja Tiwari,Simran
Mehta, et all, arXiv, aug 2021

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
