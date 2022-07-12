-- SELECT * FROM country WHERE Name = 'South Korea' OR Name = 'Japan' OR Name = 'China'; 같은말
SELECT 
    *
FROM
    country
WHERE
    Name IN ('South Korea' , 'Japan', 'China');
SELECT 
    *
FROM
    country
WHERE
    Name NOT IN ('South Korea' , 'Japan', 'China');

-- SELECT * FROM country WHERE Population >= 40000000 AND Population <= 50000000;
SELECT 
    *
FROM
    country
WHERE
    Population BETWEEN 40000000 AND 50000000;
SELECT 
    *
FROM
    country
WHERE
    Population NOT BETWEEN 40000000 AND 50000000;

SELECT 
    *
FROM
    country
WHERE
    Continent NOT IN ('North America' , 'Europe', 'Asia')
        AND GNP BETWEEN 100 AND 1000;

SELECT 
    *
FROM
    country
WHERE
    IndepYear IS NULL;	--  NULL 값을 이용할 때는 IS를 사용하자	부정 : IS NOT