# Write your MySQL query statement below

select *
from users
where 
-- right(mail, 13) = '@leetcode.com' 
mail regexp '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode[.]com$' -- '^' -> for matching the beginning of the string. 
-- '*' -> it indicates zero or more instances of string preceding it, which in case is main length of mail excluding first character and '@leetcode.com'