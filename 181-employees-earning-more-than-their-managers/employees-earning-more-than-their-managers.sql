# Write your MySQL query statement below
-- SELECT e2.id as e2Id, e2.name as e2Name, e2.salary as e2Salary, e2.managerID as e2ManagerID, e1.id as e1Id, e1.name as e1Name, e1.salary as e1Salary, e1.managerID as e1ManagerID 
SELECT e2.name as Employee
FROM Employee AS e1
INNER JOIN Employee AS e2 ON e1.id = e2.managerID
WHERE e1.salary < e2.salary