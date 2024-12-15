# Write your MySQL query statement below


Select Customer.name 
From Customer 
-- Where not referee_id = 2 or referee_id is null
Where referee_id != 2 or referee_id is null

































-- SELECT name 
-- FROM Customer 
-- WHERE referee_id is null or referee_id != 2