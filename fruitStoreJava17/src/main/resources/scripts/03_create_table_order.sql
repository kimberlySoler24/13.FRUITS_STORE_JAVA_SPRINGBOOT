--CREATE TABLE ORDER
create table orders 
(
	id int8 primary key,
	fruit_list varchar(255) not null unique,
	total_value float8 not null,
	created_date timestamp,
	updated_date timestamp
)
