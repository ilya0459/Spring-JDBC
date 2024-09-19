-- changest имя: 1
create table netology_liquibase.customers
(
id bigserial primary key not null,
name varchar(50) not null,
surname varchar(100) not null,
age int check(age > 0 and age < 150) not null,
phone_number varchar(30)
);

-- rollback drop table  netology_liquibase.customers  - это для бесплат версии Fiyway

-- changest имя: 2

alter table netology_liquibase.customers drop column phone_number














