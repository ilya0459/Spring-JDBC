create table netology_liquibase.orders
(
order_id bigserial primary key not null,
order_date date not null,
product_name varchar(255) not null,
amount int check(amount > 0 ) not null,
customer_id integer NOT NULL,
FOREIGN KEY (customer_id) references netology_liquibase.customers (id)
);