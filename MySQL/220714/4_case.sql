SELECT * FROM world.country;
-- NULL 일때 0.0 으로 나타내보자
SELECT 
    Name, CASE
        WHEN LifeExpectancy IS NULL THEN 0.0
        ELSE LifeExpectancy
    END AS Life
FROM country;
SELECT -- if True -> THEN Flase -> ELSE
    CASE
        WHEN 10 > 5 THEN '왼쪽이 오른쪽보다 큽니다'
        ELSE '왼쪽이 오른쪽보다 작거나 같습니다'
    END;
    -- if else
SELECT CASE WHEN 10 > 5 THEN '왼쪽'
			WHEN 10 = 5 THEN '같음'
			WHEN 10 < 5 THEN '오른쪽'
			END AS '비교';		
