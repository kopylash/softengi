create table addresses (
id serial primary key not null,
city varchar(50) not null,
street varchar(50) not null);




create table employers (
id serial primary key not null,
company varchar(50) not null,
activity_field varchar(50) not null,
address_id int references addresses(id));

create table users (
id serial primary key not null,
name varchar(50) not null,
surname varchar(50) not null,
address_id int references addresses(id),
employers_id int references employers(id));

create table deposits (
id serial primary key not null,
amount decimal(15,2) not null,
currency varchar(3) not null,
user_id int references users(id));