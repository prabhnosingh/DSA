# Write your MySQL query statement below


select tweets.tweet_id
from tweets
where char_length(tweets.content) > 15






























-- SELECT tweet_id
-- FROM Tweets 
-- -- WHERE LENGTH(content) > 15
-- WHERE CHAR_LENGTH(content) > 15