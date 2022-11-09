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
  - [3.3 System Requirements](#33-system-requirements)
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

![The Overall System Design](/images/311.png)

### 3.1.2 Module View 

![Module View](/images/312.jpg)

***
**Module Name:** Interface Module

**Responsibility:** This module takes care of the user action with the system

**Relations:** Each action taken by the user depends on the application logic module to give a
response to the user's action

**Visibility of interface:** This module is visible to the end-user of the system

**Constraints:** The response highly depends on the application logic, without that the interface is
barely a static page

**Interface Submodule**

**Submodule Name:** Home Screen

**Responsibility:** This module provides two options for the user, either Login or Create
new user

**Relations:** On opting on of the option, it navigates to either Login submodule or Create
new user submodule

**Visibility of interface:** This module is visible to the end-user of the system

**Submodule Name:** Log In

**Responsibility:** This module takes care of the user’s input for login details

**Relations:** This module depends on the submodule of the business logic module

**Visibility of interface:** This module is visible to the end-user of the system

**Module Name:** Create User

**Responsibility:** This module takes care of the new user creation in the system

**Relations:** This module depends on the submodule of the application logic module

**Visibility of interface:** This module is visible to the end-user of the system

**Module Name:** Payment Screen

**Responsibility:** This module takes care of the details that the user inputs for the
transaction to process

**Relations:** The transaction result depends on the transaction submodule of the
application logic module

**Visibility of interface:** This module is visible to the end-user of the system
***
**Module Name:** Application Logic Module

**Responsibility:** This module is responsible for providing an appropriate response to the user's
action

**Relations:** The Interface module depends on this module which is in turn dependent on the
analytic module for transaction actions

**Visibility of interface:** This module is not directly accessible by the end-user.

**Constraints:** Only the request from the interface module is taken into account

**Submodule Name:** LogInuser

**Responsibility:** The user login details are taken from the login interface (HTTP POST
request) and validated against the details in the database

**Relations:** Depends on the data from the interface and depends on the data present in
the submodule user database

**Submodule Name:** Create User

**Responsibility:** The user details entered in the interface should be validated for
uniqueness and should be stored in the user database

**Relations:** Depends on the data from the interface and depends on the data present in
the submodule user database

**Submodule Name:** Transaction

**Responsibility:** This module takes care of the most important aspect of either
processing the transaction or declining it

**Relations:** The decision made by this module depends on the Analytic module decision

**Submodule Name:** User database

**Responsibility:** This module stores all the user details of the transaction details and
provides them to other submodules as and when needed

**Relations:** All submodules depends on this module for accessing the data
***
**Module Name:** 2 Way Connector Module

**Responsibility:** The sole responsibility of this module is to transfer transaction data from the
transaction submodule to the Analytic module and return the status of the transaction from the
Analytic module to the transaction submodule

**Relations:** This module depends on transaction submodule for data and analytic submodule for
prediction

**Visibility of interface:** This module has two endpoints through which the transaction
submodule and analytic module can connect.
***
**Module Name:** Analytical module

**Responsibility:** This module does the analytics part of the system, wherein it takes transaction
data as input and provides the result whether the transaction is fraudulent or not.

**Relations:** It depends on the two-way connector to pass transaction data from the transaction
submodule

**Visibility of interface:** The two-way connector is the only module that can access the results
from the analytic module
***
**Module Name:** Data Store Module

**Responsibility:** The dataset that is used for the model training is stored in this module

**Relations:** The data on which the analytics is dependent is stored in this module

**Visibility of interface:** Visible only to the Analytic module

**Submodule Name:** Raw Data

**Responsibility:** Stores the historical data of the transactions

**Relations:** The Preprocessing module depends on his module for the dataset

**Submodule Name:** Preprocessed Data

**Responsibility:** The raw data is taken and processed into a form can be fed for the
analytical model training

**Relations:** The analytic model depends on this data module for both training and testing
the model

**Submodule Name:** Trained Model

**Responsibility:** The trained model is stored here to access as and when a new
transaction is sent to the analytic model for prediction

**Relations:** Analytic model depends on this module for retrieving the already trained
model and updating the trained model with the latest transactions.


### 3.1.3 Component and Connector View 

![Component and Connector View](/images/313.png)

#### Overview

System users interact with different system components over the internet through published API
interfaces that allow interoperability.

#### Elements

**Components:** End Users, Service Users, Service Providers, Infrastructure Components
(Gateway Manager, Security Manager, User Manager, Transaction Manager, Data Layer
Manager, AWS based Components)

**Connectors:** Call Return (HTTP, REST calls), Internal Data calls

##### Relations

Attachment of a service call to a service endpoint

#### Properties

Our system considers security and performance for quality attributes. Other attributes can also
be a ssociated to the system and services in future.

For big data, our system considers 3Vs (Volume, Velocity, Variety)

**Volume:** AWS S3 handles high volume storage, AWS Spark can process queries on high
volume data

**Velocity:** Batch processing

**Variety:** Addressed by PreProcessing of data

#### Constraints:

* End users must securely connect with the System Gateway
* A service user may also be a service provider
* Infrastructure components may mediate the interaction between service consumers and
service providers such as:

**Gateway Manager:** Core data communication channel in the system

**Data Layer Manager:** Controls access to Data Layer, Facade based design pattern

**AWS SageMaker:** Perform analytics and also provide communication channel between
AWS EMR and S3


### 3.1.4 Allocation View 

![Allocation View](/images/314.png)

### 3.1.5 Quality View 

![Quality View](/images/312.png)

## 3.2 System Usage 
### 3.2.1 Sequence Diagram 
#### 3.2.1.1 User Login 

![User Login](/images/3211.png)

#### 3.2.1.2 User Logout 

![User Logout](/images/3212.png)

#### 3.2.1.3 Register a User 

![Register a User](/images/3213.png)

#### 3.2.1.4 Process a Credit Card Transaction 

![Process a Credit Card Transaction ](/images/3214.png)

## 3.3 System Requirements 


Our Big Data Analytics system is composed of the following services:

* User Interface

* Transaction Service

* Data Layer Manager

* Analytics Service

* Data Storage (AWS S3)

* Data Preprocessing

**Service 1: User Interface**

● Our UI would be a web based dynamic html page, which can be used for
user's I/O operations

![Service 1: User Interface](/images/33service1.png)

**Service 2: Transaction Service**

● Transaction service interacts with UI and Data layer to handle all the user,
transactions, and security related operations

![Service 2: Transaction Service](/images/33service2.png)

**Service 3: Data Layer Manager**

● Facade design pattern component to access Data Layer

![Service 3: Data Layer Manager](/images/33service3.png)

**Service 4: Analytics Service**

● Analytics service runs the analytics and is the middleware between the
Spark, S3 and Data Layer Manager

![Service 4: Analytics Service](/images/33service4.png)

**Service 5: Data Storage (AWS S3)**

● S3 is our data storage facility, which will store Input (Data Store), Sql
Scripts, Logging Script and Output for data processing operations

![Service 5: Data Storage (AWS S3)](/images/33service5.png)

**Service 6: Data Preprocessing**

● Pre-processing and processing of raw data received from data layer and
sent to the analytics for further prediction

![Service 6: Data Preprocessing](/images/33service6.png)

# 4 Implementation 
## 4.1 User Interface (UI) 


The user interface of our application has 4 forms, the ‘Payment Portal’, ‘Login Page’, ‘Create
New User Page’ and ‘Transaction Page’. Screenshots of all the forms are attached below:


![](/images/41a.png)
![](/images/41b.png)
![](/images/41c.png)
![](/images/41d.png)

## 4.2 Cloud-based Services 


The entire system setup uses multiples services provided by the AWS cloud. Each service used
and the purpose for which it has been used is pointed out below:

● **EC2:** Amazon’s Elastic compute cloud provides the service of virtual computers. The
transaction microservices and the front end application is hosted using these EC2
instances.

● **S3:** Amazon S3 is a simple storage service. The storing and retrieving of data sets,
storing the preporossed data, and also the storage of all microservies deployed is
handled by the S3 buckets.

● **Elastic Beanstalk:** As an alternative to explicitly configuring EC2, S3 and load
balancers, AWS provides elastic beanstalk as a combined service that allows to deploy
applications independent of configurations. This service is used to deploy our flask
based microservcie in which the preprocessing of each incoming transaction is handled.

● **Sagemaker:** Used to create ML model, train the model and deploy the trained model in
cloud

● **AWS Lambda:** It is a computing service that runs code in response to events and
automatically manages the computing resources required by that code. The end point of
the ML model is triggered from the lamda function

● **Amazon API Gateway:** The lambda function is exposed to other services via the API
Gateway service.


## 4.3 Cloud-based Data Analytics 


Cloud-based Data analytics is the process of using analytic algorithms in the cloud to analyse
data in a private or public cloud and then delivering a desired result. Cloud analytics entails the
use of scalable cloud computing in conjunction with advanced analytic tools to find patterns in
data and derive new insights. Amazon services are used for data analytics part of this project.


### 4.3.1 SageMaker 

SageMaker is the machine learning service for amazon. SageMaker can be used
to design and train machine learning models fast and simple without considering
infrastructure needs. It has the ability to deploy the developed model directly as
an endpoint that is production ready hosted environment. There is no need for
server and environment management as its all handled by SageMaker. This
project uses SageMaker itself and many of its subservices and features.


### 4.3.2 XGBoost 


XGBoost stands for “Extreme Gradient Boosting”. It is a distributed gradient
boosting library that is geared for efficiency, flexibility, and portability. It uses the
Gradient Boosting framework to construct machine learning algorithms. XGBoost
uses parallel tree boosting (also known as GBDT or GBM) to tackle a variety of
data science issues quickly and accurately. The same algorithm may tackle
problems with billions of instances in a distributed environment (Hadoop, SGE,
MPI).


## 4.4 Cloud-based Microservices 


The microservies that responds to the user interafce actions are all implemented
using Java Springboot. These services have the following API endpoints:


### 4.4.1 Gateway Manager Endpoints 
### 4.4.2 Security Manager 
### 4.4.3 Transaction Manager 
### 4.4.4 User Manager 
### 4.4.5 Data Layer Manager 
# 5 Big Data Considerations 


Role of Big Data in Fraud Detection
Day-to-day transactions and historical transactions have grown to several PB in
recent years. Increasing volumes, velocity, and variability of data are making
machine learning algorithms less efficient. The Big data frameworks will facilitate
efficient data ingestion to analytical servers.
This project is cloud based. Cloud computing is the transmission of computing
services including servers, storage, databases, networking, software, analytics,
and intelligence via the Internet (“the Cloud”) in order to provide speedier
innovation, more flexible resources, and economies of scale. Big data
considerations for this project are all met within the cloud. There are many
companies offering cloud services, namely Amazon(AWS), Microsoft(Azure),
Google(GCP). This project incorporates AWS services for its deployment.


## 5.1 Velocity 


Velocity for big data refers to the pace at which data is created and transferred.
This is a critical consideration for businesses that want their data to flow rapidly
so that they may make the best business decisions possible. This project is
designed with velocity in mind, be it transactions per second or querying the
results and stored data. AWS services ensure scalability for peak hours and to
allocate more resources when necessary, for example when a query is being
done in S3 which is the storage service for AWS and our stored data.


## 5.2 Volume 


Volume refers to the total amount of data available. As the initial size and amount of
data acquired, volume is like the foundation of big data. Big data is defined as data with
a sufficiently enormous volume. Although our current data volume is low this project is
designed with volume considerations in mind. S3 secures the scalability of volume and
can accomodate unlimited amount of transactions all with the costs in mind, meaning
you only pay as much as you use.


## 5.3 Value 


The value of big data comes from insight discovery and pattern detection, which
leads to more efficient operations, greater customer connections, and other clear
and provable economic benefits. The core concept of this project was to extract
more value through the use of machine learning algorithms and to ensure
security and safety of the clients and waste of resources.


## 5.4 Other Big data characteristics 


Big data is a thousand heads hydra. The are many characteristics for big data
and they are ever changing and evolving. There are more characteristics that our
project might have encountered or solved but the most notable ones that were
directly involved were mentioned above.


# 6 Project Plan 
## 6.1 Time Schedule For Completion Of The Project Work 

![ime Schedule For Completion Of The Project Work ](/images/61.png)

# 7 Summary and Future Work 


We proposed a Credit Card Fraud detection model using cloud services to
cope with the high processing needed to train the model with 20 million records
from the dataset that is used. The analytics model returns the result of analytics
and it is integrated with the transaction service result to decide weather the
transaction has to be processed or declined.
The enhancement to our project that we can think of is to try to implement live
streaming data using some of the real-time streaming data pipelines, so that the
velocity component of Big data may be satisfied adequately in a real-world
scenario.

