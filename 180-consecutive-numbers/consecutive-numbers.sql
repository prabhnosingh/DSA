# Write your MySQL query statement below

select distinct num as ConsecutiveNums 
from logs
where (id + 1, num) in (select * from logs) and (id - 1, num) in (select * from logs)