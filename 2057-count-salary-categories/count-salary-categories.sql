# Write your MySQL query statement below

-- select category, ifnull(count(category), 0) as accounts_count
-- from 

-- (select 
-- case
-- when income < 20000 then 'Low Salary'
-- when income >= 20000 and income <= 50000 then 'Average Salary'
-- else 'High Salary'
-- end as category 
-- from accounts) subaccounts

-- group by category
 
select 'Low Salary' as category, count(account_id) as accounts_count 
from accounts 
where income < 20000

union

select 'Average Salary' as category, count(account_id) as accounts_count 
from accounts
where income between 20000 and 50000

union

select 'High Salary' as category, count(account_id) as accounts_count 
from accounts 
where income > 50000
