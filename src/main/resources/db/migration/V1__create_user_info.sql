create table user_info(
user_id int primary key auto_increment,
user_name varchar(25) not null,
user_password varchar(25) not null,
user_email varchar(30) not null,
user_address varchar(70) not null,
unique(user_email));