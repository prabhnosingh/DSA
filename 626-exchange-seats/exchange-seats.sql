# Write your MySQL query statement below

select id,
case
when id % 2 = 0 then lag(student) over(order by id) -- in case id is even, fetch the student from previous row
else coalesce(lead(student) over(order by id), student) -- in case id is odd, fetch the student from next row 
-- coaleasce returns first non null value in a list
end as student
from seat