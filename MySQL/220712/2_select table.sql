SELECT 
    *
FROM
    country;

SELECT 
    *
FROM
    city;

SELECT 
    Name, Population
FROM
    country;

DESC country;	-- TABLE의 구조를 보자

SELECT 
    Code, GNP
FROM
    country;

SELECT 
    *
FROM
    country
WHERE
    NAME = 'South Korea';

SELECT 
    *
FROM
    country
WHERE
    NAME = 'Japan';

SELECT 
    *
FROM
    country
WHERE
    NAME = 'China';

SELECT 
    *
FROM
    country
WHERE
    Continent = 'Asia';

SELECT 
    *
FROM
    country
WHERE
    Name = 'South Korea' OR Name = 'Japan'
        OR Name = 'China';

SELECT 
    *
FROM
    country
WHERE
    Population >= 40000000;

SELECT 
    *
FROM
    country
WHERE
    Population >= 40000000
        AND Population <= 50000000;

SELECT 
    *
FROM
    country
WHERE
    Continent <> 'Asia';