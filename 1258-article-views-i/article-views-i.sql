# Write your MySQL query statement below
SELECT distinct Views.author_id as id
FROM Views 
WHERE Views.author_id = Views.viewer_id ORDER BY author_id ASC