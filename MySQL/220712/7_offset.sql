SELECT * FROM country;
-- OFFSET : 숫자만큼 건너뛰고 보여준다 아래는 OFFSET을 생략한 줄임말
SELECT * FROM country LIMIT 1 OFFSET 2;
SELECT * FROM country LIMIT 2, 1;

-- page 나누기 (페이징)
SELECT * FROM country LIMIT 10 OFFSET 0;
SELECT * FROM country LIMIT 10 OFFSET 10;
SELECT * FROM country LIMIT 10 OFFSET 20;