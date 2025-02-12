# Write your MySQL query statement below
select p.product_id, ifnull(round(sum(u.units * p.price) / sum(u.units), 2), 0) as average_price 
-- ifnull returns the expression if it (expression) is not null and returns the value (in this case 0), if the expression computes to null
-- select *
from prices p
left join unitssold u on p.product_id = u.product_id
and u.purchase_date between p.start_date and p.end_date
-- where p.start_date <= u.purchase_date <= p.end_date 
group by p.product_id
