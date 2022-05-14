drop table if exists store_users;

create table store_users (
	store_user_id serial,
	store_user_username varchar(25),
	store_user_password varchar(25),
	store_user_firstname varchar(25),
	store_user_lastname varchar(25)
);

/*DUMMY DATA*/
--CREATE COMMANDS
insert into store_users (store_user_username, store_user_password, store_user_firstname, store_user_lastname)
values 
	('test', 'testpassword', 'Tester', 'Test'), 
	('jdoe', 'password', 'John', 'Doe'), 
	('admin', 'password', 'Manager', 'Admin');

--READ COMMANDS
select * from store_users order by store_user_id;
select * from store_users where store_user_id = 1;
select * from store_users where store_user_firstname = 'Manager';

--UPDATE COMMANDS 
update store_users 
set 
	store_user_username='myuser', 
	store_user_password='mypassword', 
	store_user_firstname='Jane', 
	store_user_lastname='Doe'
where store_user_id = 1;

--DELETE COMMANDS
delete from store_users where store_user_id = 1;