# Write your MySQL query statement below
-- select query_name, round(sum(rating / position) / count(query_name), 2) as quality, 
-- round((select count(q2.rating) from queries q2 where q2.rating < 3 and q2.query_name = q1.query_name) * 100 / count(query_name), 2) as poor_query_percentage
-- from queries q1
-- group by query_name


select query_name,
round(avg(cast(rating as decimal) / position), 2) as quality,
round(sum(case when rating < 3 then 1 else 0 end) * 100 / count(*), 2) as poor_query_percentage
from queries
group by query_name