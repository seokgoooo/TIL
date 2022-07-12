SELECT * FROM country;

-- 인구가 가장 많은 1개의 국가 조회하기
SELECT 
    *
FROM
    country
ORDER BY Population DESC
LIMIT 1;

-- 면적순 탑 5
SELECT * FROM country ORDER BY SurfaceArea DESC LIMIT 5;

-- Continent가 'Asia'인 국가들 중 면적이 좁은 순으로 10개 국가
SELECT * FROM country WHERE Continent = 'Asia' ORDER BY SurfaceArea LIMIT 10;

-- Region이 '~Africa'로 끝나는 국가들 중 독립년도(IndepYear)가 가장 최근인 10개 국가
SELECT * FROM country WHERE Region LIKE '%Africa' ORDER BY IndepYear DESC LIMIT 10;

-- 면적당 인구비율 (Population / SurfaceArea) 탑 10
SELECT * FROM country ORDER BY Population / SurfaceArea DESC LIMIT 10;

-- (GNP - GNPOld 변화량) 탑 10
SELECT * FROM country ORDER BY GNP - GNPOld DESC LIMIT 10;