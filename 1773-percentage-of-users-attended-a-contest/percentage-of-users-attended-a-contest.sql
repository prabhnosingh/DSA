# Write your MySQL query statement below
select contest_id, round((count(contest_id)/(select count(user_id) from users)) * 100, 2) as percentage 
-- from register r
-- left join users u on r.user_id = u.user_id
from register
group by contest_id
order by percentage desc, contest_id asc

