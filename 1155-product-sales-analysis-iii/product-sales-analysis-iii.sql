

-- # Write your MySQL query statement below
-- select product_id, year as first_year, quantity, price
-- from sales s1
-- where year = (select min(s2.year) from sales s2 where s1.product_id = s2.product_id group by s2.product_id)
-- group by product_id



# Write your MySQL query statement below
select product_id, year as first_year, quantity, price
from sales s1
where (product_id, year) in (select product_id, min(year) from sales group by product_id) 
-- while using "in", consider the column(s) that are going to consititute the final table's primary key.
-- In this case (product_id, year) were the combination columns with unique values


