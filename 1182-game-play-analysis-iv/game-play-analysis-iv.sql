# Write your MySQL query statement below

select round(sum(datediff((select min(a2.event_date) from activity a2 where a2.player_id = a1.player_id), a1.event_date) = -1) / count(distinct a1.player_id), 2) as fraction
from activity a1
-- group by a1.player_id