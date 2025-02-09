# Write your MySQL query statement below

select a1.machine_id, round(avg(a2.timestamp - a1.timestamp), 3) as processing_time
-- a1.timestamp, a2.timestamp
from activity a1
join activity a2
on a1.process_id = a2.process_id
where a1.machine_id = a2.machine_id
and a2.timestamp > a1.timestamp
group by a1.machine_id







































-- SELECT a1.machine_id, 
-- -- a1.timestamp, 
-- -- a2.timestamp
-- ROUND(AVG(a2.timestamp - a1.timestamp), 3) AS processing_time
-- FROM Activity a1
-- JOIN Activity a2
-- ON a1.process_id = a2.process_id
-- AND a1.machine_id = a2.machine_id
-- AND a1.timestamp < a2.timestamp
-- GROUP BY a1.machine_id
