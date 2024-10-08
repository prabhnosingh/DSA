# Write your MySQL query statement below
Select w2.id
From Weather w1 
JOIN Weather w2
ON DATEDIFF(w2.recordDate, w1.recordDate) = 1 AND w2.temperature > w1.temperature    