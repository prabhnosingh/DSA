# Write your MySQL query statement below

select employee_id, department_id
from employee
-- where primary_flag = 'Y' or employee_id in (select employee_id from employee where primary_flag = 'N' group by employee_id having count(department_id) = 1)
-- in the above query the "where primary_flag = 'N' is wrong, becasue doing so will make an invalid row valid by making its count 1 and hence resulting in count(department_id) = 1 to be true"
where primary_flag = 'Y' or employee_id in (select employee_id from employee group by employee_id having count(department_id) = 1)
group by employee_id

