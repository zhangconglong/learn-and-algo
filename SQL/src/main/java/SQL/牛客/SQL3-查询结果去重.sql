select distinct university
from user_profile;

-- 2比1快一些，但是占用的内存大了点
SELECT university
from user_profile
GROUP BY university;