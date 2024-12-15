# Write your MySQL query statement below


 select visits.customer_id, count(visits.customer_id) as count_no_trans
 from visits left join
 transactions on visits.visit_id = transactions.visit_id
 where transactions.visit_id is null 
--  where transactions.amount is null -> This cannot be used as there is a case where a user has entry 
-- in transactions table with null amount, but it is still counted as a transaction 
 group by visits.customer_id



















-- SELECT customer_id, COUNT(visit_id) AS count_no_trans
-- FROM Visits
-- LEFT JOIN Transactions 
-- USING(visit_id)
-- WHERE transaction_id IS NULL 
-- Group BY customer_id

-- SELECT customer_id, COUNT(v.visit_id) AS count_no_trans
-- FROM Visits v
-- LEFT JOIN Transactions t
-- ON v.visit_id = t.visit_id 
-- WHERE t.transaction_id IS NULL 
-- Group BY v.customer_id