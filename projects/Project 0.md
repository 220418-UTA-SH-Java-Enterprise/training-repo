# Project 0
For Project 0, you will be building a console-based application that will be presented on *Wednesday, May 4th, 2022 at 10:00AM EST*. For this application you may choose one of the following concepts: 
- a banking application 
- course registration application
- a store application

The subject/theme that your project focuses on is completely up to you:
ex. 
- a Revature bank app
- a university course registration app
- a pet store app

Send your project concept selection and subject/theme to your trainer via Slack DM and await concept approval. Deadline for approvals will be on *Friday, April 22nd at 1:00PM EST*.

## Banking Application Details

### MVP User Stories
As any kind of user, I can:
- [ ] login with my existing credentials

As a bank member, I can:
- [ ] register myself for a new user account with the system (must be secured with a password)
- [ ] create at least one account (minimun opening account must be $25)
- [ ] deposit funds into an account (use doubles, not ints)
- [ ] withdraw funds from an account (no overdrafting!)
- [ ] view the balance of my account(s) (all balance displays must be in proper currency format)
- [ ] view all transaction history for an account
- [ ] filter the transaction history view for an account by a range of currency or by type of transaction
- [ ] transfer money between accounts

As a bank manager, I can:
- [ ] view all transaction history for all accounts
- [ ] can close an account

### Suggested Bonus User Stories
As a bank member, I can:
- [ ] create multiple accounts per user (checking, savings, etc.)
- [ ] share a joint account with another user

As a bank manager, I can:
- [ ] email a statement of transaction for an account to the user's email address

Other:
- [ ] passwords in database are encrypted

## Course Registration Application Details 

### MVP User Stories
As any kind of user, I can:
- [ ] login with my existing credentials

As a faculty member, I can:
- [ ] add new classes to the registration catalog
- [ ] change the registration details for a class
- [ ] remove a class from the registration catalog (this should unregister all registered students)

As a student, I can:
- [ ] register a new account with the system (must be secured with a password)
- [ ] view classes available for registration
- [ ] register for an open and available class
- [ ] cancel my registration for a class (if within window)
- [ ] view the classes that I have registered for

### Suggested Bonus User Stories
As a user, I can:
- [ ] view all classes that have a waitlist
- [ ] add myself to a waitlist for a class
- [ ] remove myself from a waitlist for a class (if within window)

As a faculty member, I can:
- [ ] move a student from the waitlist into the registration list for a class (if within window)
- [ ] email a waitlisted student that they have been registered for the class

Other:
- [ ] passwords in database are encrypted

## Store Application Details

### MVP User Stories
As any kind of user, I can:
- [ ] login with my existing credentials

As a customer, I can:
- [ ] can edit my profile
- [ ] can add items from the store to my cart
- [ ] can remove items from my cart
- [ ] can checkout my cart to place a order with the store
- [ ] can view my order history

As a store manager, I can:
- [ ] add new items to the store inventory
- [ ] replenish item inventory for any particular item for the store
- [ ] view customers by name
- [ ] view details of any order by id or by date
- [ ] view all order history of the store
- [ ] view all order history of a customer

### Suggested Bonus User Stories
As a customer or a store manager, I can:
- [ ] view order history based on sorting (by earliest, latest, cheapest, most expensive, etc.)

As a store manager, I can:
- [ ] get a suggested order for a customer based on his order history (can be determined based on most bought, price range of overall orders, etc.)
- [ ] email a suggested order for a customer to the customer's email address

Other:
- [ ] passwords in database are encrypted

## Minimum Features
All project concepts must display the following domain-independent features/requirements in order to get a passing grade:
- [ ] Use of custom data structures (do not use java.util Collection types!)
- [ ] Basic validation of user input (e.g. no registration for classes outside of registration window, no negative deposits/withdrawals, no overdrafting, etc.) 
- [ ] Unit tests for all business-logic classes (10 minimun)
- [ ] All exceptions are properly caught and handled
- [ ] Proper use of OOP principles
- [ ] Documentation (all classes and methods have basic documentation)
- [ ] Database must consist of at least 3 tables
- [ ] Database is 3rd Normal Form Compliant
- [ ] Referential integrity within database (e.g. if a class is removed from the catalog, no students should be registered for it)
- [ ] Logging messages and exceptions to a file using a custom logger
- [ ] Generation of basic design documents (e.g. relational diagram, class diagram, flows, etc.)


## Tech Stack
Regardless of the project concept you choose, you will be required to adhere to the following tech stack:
- [ ] Java 8
- [ ] Apache Maven
- [ ] PostgreSQL (hosted on AWS RDS)
- [ ] Git SCM (hosted on GitHub)


## Repo Instructions
- Create a new private repository within this organization (naming convention: `firstname_lastname_p0`)
- Add your trainer as a contributor to the repository
- Put your project concept user stories on your README.md
- Keep this repository up to date with frequent commits and pushes (follow best practices!)
- It is recommended (though not required) that you implement some kind of branching strategy when implementing new features into your application

## Presentation
- [ ] finalized version of application must be pushed to personal repository within this organization by the presentation deadline
- [ ] 5-7 minute live demonstration of the implemented features in front of cohort, trainer, and QC