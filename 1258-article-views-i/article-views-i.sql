# Write your MySQL query statement below


Select Distinct Views.author_id as id
From Views
Where views.author_id = views.viewer_id
Order by views.author_id ASC





































-- SELECT distinct Views.author_id as id
-- FROM Views 
-- WHERE Views.author_id = Views.viewer_id ORDER BY Views.author_id ASC