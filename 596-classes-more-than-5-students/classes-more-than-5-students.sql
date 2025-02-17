# Write your MySQL query statement below

select class
from courses c1
where (select count(student) from courses c2 where c2.class = c1.class  group by class) > 4
group by class