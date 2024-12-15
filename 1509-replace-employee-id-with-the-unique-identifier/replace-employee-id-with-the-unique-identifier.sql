# Write your MySQL query statement below
select employeeuni.unique_id, employees.name
from employees 
left join employeeuni on employees.id = employeeuni.id






























-- SELECT EmployeeUNI.unique_id, Employees.name
-- FROM Employees 
-- -- LEFT JOIN EmployeeUNI ON Employees.id = EmployeeUNI.id
