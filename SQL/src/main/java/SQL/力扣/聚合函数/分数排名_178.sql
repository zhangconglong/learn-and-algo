# https://leetcode.cn/problems/rank-scores/solution/dense_rank-overpai-ming-de-shi-yong-by-q-mq4s/
# rank 排序函数

select score,
       (dense_rank() over (order by Score desc)) AS "rank" # 排名
from scores