# Write your MySQL query statement below


Select Distinct Views.author_id as id
From Views
Where Views.author_id = Views.viewer_id
Order by Views.author_id ASC





































-- SELECT distinct Views.author_id as id
-- FROM Views 
-- WHERE Views.author_id = Views.viewer_id ORDER BY Views.author_id ASC