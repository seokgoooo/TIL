-- Column 옆에 AS 로 별명을 지어줄 수 있다. (실제 Column 명이 바뀌는 건 아니다)
SELECT Code AS '코드', Name AS '이름', Population AS '인구' FROM country;

SELECT Code AS '코드', Name AS '이름', Population AS '인구', SurfaceArea AS '면적' FROM country;

SELECT 
    Code AS '코드',
    Name AS '이름',
    Population AS '인구',
    SurfaceArea AS '면적',
    ROUND(Population / SurfaceArea, 1) AS '인구밀도'
FROM
    country;

SELECT 
    Code AS '코드',
    Name AS '이름',
    Population AS '인구',
    SurfaceArea AS '면적',
    ROUND(Population / SurfaceArea, 1) AS '인구밀도'
FROM country ORDER BY 인구밀도 DESC;

SELECT 
    Code AS '코드',
    Name AS '이름',
    Population AS '인구',
    SurfaceArea AS '면적',
    ROUND(Population / SurfaceArea, 1) AS '인구밀도'
FROM country WHERE SurfaceArea <= 50000 AND Population >= 10000000;

SELECT * FROM country WHERE Continent = 'Asia' ORDER BY Population DESC;

SELECT * FROM country WHERE LifeExpectancy IS NOT NULL ORDER BY LifeExpectancy;

SELECT 
    Name,
    Population,
    GNP,
    GNPOld,
    (GNPOld - GNP) AS 'GNP 변화량'
FROM country WHERE GNP IS NOT NULL AND GNPOld IS NOT NULL ORDER BY `GNP 변화량` DESC;

SELECT * FROM country ORDER BY Continent, Population;

SELECT * FROM country ORDER BY GovernmentForm, GNP DESC;