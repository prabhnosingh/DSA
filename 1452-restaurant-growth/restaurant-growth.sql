# Write your MySQL query statement below

select visited_on,
(select sum(amount) from customer where visited_on between date_sub(c.visited_on, interval 6 day) and c.visited_on) as amount,
round((select sum(amount) / 7 from customer where visited_on between date_sub(c.visited_on, interval 6 day) and c.visited_on), 2) as average_amount
from customer c
where visited_on >= (select date_add(min(visited_on), interval 6 day) from customer) 
-- this denotes that visited_on of 'c' should be at least 6 days after the min visited_on date of the table to compensate the above 'date_sub's
group by visited_on
order by visited_on