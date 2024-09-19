create table netology.customers
(
id bigserial primary key not null,
name varchar(50) not null,
surname varchar(100) not null,
age int check(age > 0 and age < 150) not null,
phone_number varchar(30)
);

create table netology.orders
(
order_id bigserial primary key not null,
order_date date not null,
product_name varchar(255) not null,
amount int check(amount > 0 ) not null,
customer_id integer NOT NULL,
FOREIGN KEY (customer_id) references netology.customers (id)
);

insert into netology.customers (name, surname, age, phone_number)
values('Bob', 'Ivanov', 31, '8-911-111-11-11'),
('Petr', 'Petrov', 26, '8-922-222-22-22'),
('Olesia', 'Petrova', 18, '8-933-333-33-33'),
('Ania', 'Sidorova', 24, '8-944-444-44-44');

insert into netology.orders  (order_date, product_name, customer_id, amount)
values('2024-02-03', 'Tv', 6,  23000),
('2024-03-24', 'BlueRay', 5,  31000),
('2024-05-06', 'DVD-RW', 1,  14000),
('2024-07-08', 'Tv-DVD', 5, 44000);