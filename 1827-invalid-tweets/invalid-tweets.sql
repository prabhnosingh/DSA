# Write your MySQL query statement below
SELECT tweet_id
FROM Tweets 
-- WHERE LENGTH(content) > 15
WHERE CHAR_LENGTH(content) > 15