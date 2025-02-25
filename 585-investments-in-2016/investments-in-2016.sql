# Write your MySQL query statement below

-- select *
-- from insurance
-- where (lat, lon) not in (select lat, lon from insurance i2 where not i2.pid = pid)

select round(sum(tiv_2016), 2) as tiv_2016
from insurance i
where tiv_2015 in (select tiv_2015 from insurance group by tiv_2015 having count(tiv_2015) > 1)
and (lat, lon) in (
    select lat, lon
    from insurance
    -- where (lat) in (select i1.lat from insurance i1 where i1.pid = pid group by i1.lat having count(i1.lat) = 1) 
    -- select the lat while having the same pid that has count = 1, i.e. it is unique
    -- and (lon) in (select i2.lon from insurance i2 where i2.pid = pid group by i2.lon having count(i2.lon) = 1) 
    -- select the lon while having the same pid that has count = 1, i.e. it is unique
    group by lat, lon
    having count(*) = 1
)
-- group by i.tiv_2016 











-- select pid from insurance i2 group by i2.tiv_2015 having count(tiv_2015) > 1