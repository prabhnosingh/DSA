# Write your MySQL query statement below
-- select max(num)
-- from mynumbers
-- group by num
-- having count(num) = 1

select max(num) as num
from mynumbers
where (num, 1) in (select max(num), count(num) from mynumbers group by num)