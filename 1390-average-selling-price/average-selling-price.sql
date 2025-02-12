# Write your MySQL query statement below
select p.product_id, ifnull(round(sum(u.units * p.price) / sum(u.units), 2), 0) as average_price 
-- ifnull returns the expression if it (expression) is not null and returns the value (in this case 0), if the expression computes to null
-- select *
from prices p
left join unitssold u on p.product_id = u.product_id
and u.purchase_date between p.start_date and p.end_date
-- where u.purchase_date between p.start_date and p.end_date -> This does not work because in case when we have empty unitsSold table, 'where' conditions ...
-- ...generates empty table after join. But 'and' leads to a table with null values which forms the basis of "If a product does not have any sold units, its average selling price is assumed to be 0."
group by p.product_id
