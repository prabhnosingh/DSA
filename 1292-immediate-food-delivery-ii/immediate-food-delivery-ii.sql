# Write your MySQL query statement below

-- select  round(sum(customer_pref_delivery_date = (select min(d2.order_date) from delivery d2 where d1.customer_id = d2.customer_id)) * 100
--  / count(distinct customer_id), 2) 
--  as immediate_percentage 
-- from delivery d1

select round(avg(customer_pref_delivery_date = order_date) * 100, 2) as immediate_percentage 
from delivery
where (customer_id, order_date) in
(select customer_id, min(order_date) from delivery group by customer_id)