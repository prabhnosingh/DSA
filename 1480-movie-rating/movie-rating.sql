# Write your MySQL query statement below

(select u.name as results
from users u
join movierating m on u.user_id = m.user_id
group by m.user_id
order by count(m.user_id) desc, u.name limit 1
)

-- union
union all

(select m.title as results
from movies m 
join movierating mr on m.movie_id = mr.movie_id
where year(mr.created_at) = 2020 and month(mr.created_at) = 02 
group by mr.movie_id
order by avg(rating) desc, m.title limit 1
) 




