select*
from netology.customers c
join netology.orders o  on c.id = o.order_id
where lower(name)=lower(:name);