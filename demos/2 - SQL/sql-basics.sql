--single comment line
/*
 * multiple line comment 
 */
/* - What is SQL?
 * - stands for "structured query language"
 * - this is used to create and manage relational database using human-readable language
 * 
 * - What is a database?
 * = a collection of related data
 * 
 * - DBMS (database management system) is a collection of programs used to create and maintain a database.
 * 
 * - Why used a database?
 * = store our data in a structured format
 * = allows us concurrent use of data to many users
 * = control access to the data through usage of admin priveleges
 * = maintain data integrity aka maintain the consistency and accuracy of our data
 * = provides good data backup and recovery
 * 
 * - RDBMS (relational database management system) refers to a database that stores data in a structured format
 * consisting of tables, rows, and columns
 * 
 * table = collective group of data
 * column = data catergories
 * rows = particular instances of a data category
 * 
 * schema = layout of our database (similar to how classes are blueprints of our java objects)
 * -----------------
 * - Establishing relationships between tables through use of PKs and FKs is called "referenial integrity".
 * 
 * Ex.
 * 
 * Demo Schema:
 * 		- Departments
 * 			+ id (primary key) (unique identifer for a table = unique, not null)
 * 			+ name
 * 			+ monthly budget
 * 
 * 		- Employees
 * 			+ id (PK)
 * 			+ first_name
 * 			+ last_name
 * 			+ birthdate
 * 			+ monthly_income
 * 			+ department_id (foreign key) (unique identifer that is a PK in another table)
 * 			+ hire_date
 * 			+ job_title
 * 			+ email
 * 
 * 		- Products
 * 			+ id (PK)
 * 			+ name
 * 			+ price
 * 			+ expiration_date
 * */

/* - SQL can be broken down into 5 sublanguages:
 * 1) DDL (Data Definition Language) = used to manage the structure of datbase schema
 * Commands: CREATE, DROP, TRUNCATE, ALTER, RENAME
 * 2) DML (Data Manipulation Language) = used to manipulate the data in our database
 * Commands: INSERT, UPDATE, DELETE (commonly known as CRUD operations)(Create, Read, Update, Delete)
 * 3) DQL (Data Query Language) = used to retrieve information from our database
 * Commands: SELECT
 * 4) DCL (Data Control Language) = used to give privileges/access of our data
 * Commands: GRANT, REVOKE
 * 5) TCL (Transaction Control Language) = used to apply the changes of our data permanently into our database
 * Commands: COMMIT, ROLLBACK, SAVEPOINT
 */

-- common to see a series of DROP table statements at the beginning of any table creation script
drop table if exists products;
drop table if exists employees;
drop table if exists departments;

-- create my tables 
create table departments(
--serial is a autoincremented numeric datatype in SQL
-- varchar is for string values
-- numeric is for decimal numbers
	id serial constraint department_pk primary key, --inline constraint declaration
	name varchar(25) unique not null, --candidate key (a column that COULD be a primary key)
	monthly_budget numeric(8, 2) -- first # is precision (# of digits allowed), second # is scale (# of decimal places)
);

-- sql strings are single-quoted
insert into departments values (1, 'Accounting', 20000);
insert into departments (name, monthly_budget) values('Marketing', 15000);

--inserting multiple values
insert into departments (name, monthly_budget)
values
	('IT', 30000),
	('Human Resources', 25000),
	('Customer Service', 2000),
	('Internal Affairs', 5000);

--query the records within the table 
-- * is the the wildcard for all columns within a given table
select * from departments;

-- to narrow down my info search to a particular id numbers 
-- where clause is used to filter our information based on a condition
select * from departments where id = 4;
select name, monthly_budget from departments where id = 3;
