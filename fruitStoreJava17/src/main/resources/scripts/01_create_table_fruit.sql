-- CREATE ENTITY FRUIT

create table fruits 
(
	id int8 primary key,
	"type" varchar(50) not null unique,
	quantity int8 not null,
	price float8 not null,
	created_date timestamp,
	updated_date timestamp
)
