# Project 1: Employee Reimbursment System (ERS)
Project 1 will be to use JDBC or an object relational mapping (ORM) framework. ORM frameworks will allow for a simplified and SQL-free interaction with the relational data source.

Additionally, your team will need to build a simple CRUD web application based on the ERS specs provided below. You should leverage the Java EE Servlet API to expose endpoints that allow for interaction with the application.

## ERS Web Application Summary
* The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. 
* All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. 
* Finance managers can log in and view all reimbursement requests and past history for all employees in the company. 
* Finance managers are authorized to approve and deny requests for expense reimbursement.

## Tech Stack
- [ ] Java 8
- [ ] JUnit
- [ ] Mockito
- [ ] Apache Maven
- [ ] JaCoCo
- [ ] Hibernate (optional)
- [ ] JDBC (optional)
- [ ] Jackson library (for JSON marshalling/unmarshalling)
- [ ] Java EE Servlet API (v4.0+)
- [ ] PostGreSQL deployed on AWS RDS
- [ ] Postman
- [ ] AWS CodeBuild
- [ ] AWS CodePipeline
- [ ] Git SCM (on GitHub)

## Employee User Stories 
### MVP:
- [ ] An Employee can login
- [ ] An Employee can view the Employee Homepage
- [ ] An Employee can logout
- [ ] An Employee can submit a reimbursement request
- [ ] An Employee can view their pending reimbursement requests
- [ ] An Employee can view their resolved reimbursement requests
- [ ] An Employee can view their information
- [ ] An Employee can update their information
### Stretch Goals:
- [ ] An Employee can upload an image of his/her receipt as part of the reimbursement request 
- [ ] An Employee receives an email when one of their reimbursement requests is resolved

## Manager User Stories
### MVP:
- [ ] A Manager can login
- [ ] A Manager can view the Manager Homepage
- [ ] A Manager can logout
- [ ] A Manager can approve/deny pending reimbursement requests
- [ ] A Manager can view all pending requests from all employees
- [ ] A Manager can view all resolved requests from all employees and see which manager resolved it
- [ ] A Manager can view all Employees
- [ ] A Manager can view reimbursement requests from a single Employee 
### Stretch Goals:
- [ ] A Manager can view images of the receipts from reimbursement requests

## Flowcharts
**State-chart Diagram (Reimbursement Statuses)** 
<br>
![](./imgs/state-chart.jpg)
<br>

**Reimbursement Types**
Employees must select the type of reimbursement as: LODGING, TRAVEL, FOOD, or OTHER.
<br>

**Logical Model**
<br>
![](./imgs/logical.jpg)
<br>

**Physical Model**
<br>
![](./imgs/physical.jpg)
<br>

**Use Case Diagram**
<br>
![](./imgs/use-case.jpg)
<br>

**Activity Diagram**
<br>
![](./imgs/activity.jpg)
<br>

**Overall Application Design Diagram**
<br>
<img src="./imgs/P1%20Design%20Pattern%20Layout.png" style="background-color: #FFFFFF;">
<br>

## Technical Requirements
### MVP:
- [ ] The back-end system shall utilize one of the following: **1) JDBC, 2) Hibernate, or 3) Custom-made using Reflections API**. 
- [ ] The back-end system shall connect to an **AWS RDS Postgres database**. 
- [ ] Programmatic persistence of entities (basic CRUD support) using ORM or JDBC/Hibernate.
- [ ] File-based or programmatic configuration of entities (applicable for options 2 & 3 only).
- [ ] The back-end source code should be included within the web application as a Maven dependency (option 3 only).
- [ ] 60% line coverage of all service layer classes.
- [ ] Generated Jacoco reports that display coverage metrics.
- [ ] Usage of the java.util.Stream API within your project.
- [ ] The application shall use Postman to test endpoints that call your server-side components. 
- [ ] The application shall follow proper layered architecture.
- [ ] The application shall implement log4j for appropriate logging. 

### Stretch Goals:
- [ ] Custom ORM supports basic transaction management (begin, commit, savepoint, rollback) 
- [ ] Custom ORM supports connection pooling
- [ ] Session-based caching to minimize calls to the database for already retrieved data
- [ ] Deployment of web application to AWS EC2 (use of AWS Elastic Beanstalk is permitted) 
- [ ] Continuous integration pipelines that builds some main branch each project (the ORM and the web app, separately)
- [ ] Passwords shall be encrypted in Java and securely stored in the database. 

## Init Instructions
- Create a new private repository within this organization for your custom ORM (naming convention: `ers_orm_name_p1`; with `orm_name` being replaced by the name of your custom library)
    - Make sure to add your trainer and team members as contributors to the repo
    - You would need a secondary repo if you are doing the custom ORM option to host your web app (naming convention: `ers_webapp_orm_name_p1`; with `orm_name` being replaced by the name of your custom library); if you are doing Hibernate or JDBC, you will only need **one** repository.

## Presentation
- Finalized version of custom ORM and web application must be pushed to repository within this organization by the presentation date (**May 18th, 2022**)
- 10-15 minute live demonstration of the web application (that leverages your custom ORM/persistence app); demonstration will be performed using Postman to query your API's endpoints

### Resources for researching ORMs
- [What is an ORM?](https://blog.bitsrc.io/what-is-an-orm-and-why-you-should-use-it-b2b6f75f5e2a)
- [Hibernate Documentation](https://hibernate.org/orm/documentation/5.4/)
- [JavaLite ActiveJDBC Documentation](https://javalite.io/documentation)
- [Using Java Reflection](https://www.oracle.com/technical-resources/articles/java/javareflection.html)
