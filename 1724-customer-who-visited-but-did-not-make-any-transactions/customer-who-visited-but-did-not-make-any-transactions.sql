# Write your MySQL query statement below
-- SELECT customer_id, COUNT(visit_id) AS count_no_trans
-- FROM Visits
-- LEFT JOIN Transactions 
-- USING(visit_id)
-- WHERE transaction_id IS NULL 
-- Group BY customer_id

SELECT customer_id, COUNT(v.visit_id) AS count_no_trans
FROM Visits v
LEFT JOIN Transactions t
ON v.visit_id = t.visit_id 
-- USING(visit_id)
WHERE t.transaction_id IS NULL 
Group BY v.customer_id