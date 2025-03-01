# Write your MySQL query statement below

select max(salary) as SecondHighestSalary -- using max() here only to satisfy null condition. max() tends to return null if the value is empty
from employee e1
where (select count(distinct(e2.salary)) from employee e2 where e2.salary > e1.salary) = 1