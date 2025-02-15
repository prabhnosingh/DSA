# Write your MySQL query statement below

select  round(sum(customer_pref_delivery_date = (select min(d2.order_date) from delivery d2 where d1.customer_id = d2.customer_id)) * 100
 / count(distinct customer_id), 2) 
 as immediate_percentage 
-- select delivery_id, customer_id, sum(case when customer_pref_delivery_date = min(order_date) then 1 else 0 end) as immediate_percentage 
from delivery d1
-- group by customer_id