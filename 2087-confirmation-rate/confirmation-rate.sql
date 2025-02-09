# Write your MySQL query statement below

-- select s.user_id, 
-- case
-- when round((select count(c2.action) from confirmations c2 where c2.action = 'confirmed' and c2.user_id = c.user_id group by c2.user_id)/count(s.user_id), 2) is null then 0
-- else round((select count(c2.action) from confirmations c2 where c2.action = 'confirmed' and c2.user_id = c.user_id group by c2.user_id)/count(s.user_id), 2)

-- end as confirmation_rate
-- from signups s
-- left join confirmations c on s.user_id = c.user_id
-- -- where c.action = 'confirmed'
-- group by s.user_id

select s.user_id, round(avg(if(c.action = 'confirmed', 1, 0)), 2) as confirmation_rate
from signups s 
left join confirmations c on s.user_id = c.user_id
group by s.user_id