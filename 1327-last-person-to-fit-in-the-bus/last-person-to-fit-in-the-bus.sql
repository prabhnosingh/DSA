# Write your MySQL query statement below
select person_name
from 
(select person_name, sum(weight) over(order by turn) as cw from queue) 
-- the above query denotes a table   
-- 'over' is like specifying the rows to perform the action on
tempName
where cw <= 1000
order by cw desc limit 1