-- Database: softengi



insert into addresses(city,street) values ('Kiev','Peremohy avenue');
insert into addresses(city,street) values ('London','Picadilly Circus');

insert into employers(company,activity_field,address_id) values ('Ciklum','IT',2);
insert into employers(company,activity_field,address_id) values ('Softengi','IT',1);

insert into users(name,surname,employers_id,address_id) values ('Vladislav','Kopylash',1,2);
insert into users(name,surname,employers_id,address_id) values ('John','Doe',2,1);
insert into users(name,surname,employers_id,address_id) values ('Svitlana','Shepeta',1,2);

insert into deposits(amount,currency,user_id) values (5,'UAH',1);
insert into deposits(amount,currency,user_id) values (3000.53,'USD',2);
insert into deposits(amount,currency,user_id) values (1496.11,'USD',3);





