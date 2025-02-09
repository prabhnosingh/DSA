# Write your MySQL query statement below

-- select managerId, count(managerId)
-- from employee
-- where managerId is not null 
-- group by managerId


select e1.name
from employee e1 
join employee e2 on e1.id = e2.managerId
group by e2.managerId
having count(*) >= 5
-- where count(e1.name) > 4
-- group by e1.name