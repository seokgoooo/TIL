SET @rowCount := 239;
SET @pageNumber := 1;
SET @pagePer := 10;
SET @totalPage := round(@rowCount / @pagePer / @pageNumber);	-- 계산 (수식 작성)
SELECT @totalPage;
-- 239행을 가지는 country 테이블을 각 페이지별 행의 개수와 보고자 하는 페이지 번호를 정하면
-- 해당 row들을 조회할 수 있는 SELECT 문을 작성해보기
-- SELECT * FROM country LIMIT 0 부터 + @pagePer, @pagePer;

SELECT * FROM country LIMIT 0, 10;
SELECT * FROM country LIMIT 10, 10;
SELECT * FROM country LIMIT 20, 10;
SELECT * FROM country LIMIT 30, 10;
SELECT * FROM country LIMIT 40, 10;
SELECT * FROM country LIMIT 50, 10;
SELECT * FROM country LIMIT 60, 10;
SELECT * FROM country LIMIT 70, 10;
SELECT * FROM country LIMIT 80, 10;
SELECT * FROM country LIMIT 90, 10;
SELECT * FROM country LIMIT 100, 10;
SELECT * FROM country LIMIT 110, 10;
SELECT * FROM country LIMIT 120, 10;
SELECT * FROM country LIMIT 130, 10;
SELECT * FROM country LIMIT 140, 10;
SELECT * FROM country LIMIT 150, 10;
SELECT * FROM country LIMIT 160, 10;
SELECT * FROM country LIMIT 170, 10;
SELECT * FROM country LIMIT 180, 10;
SELECT * FROM country LIMIT 190, 10;
SELECT * FROM country LIMIT 200, 10;
SELECT * FROM country LIMIT 210, 10;
SELECT * FROM country LIMIT 220, 10;
SELECT * FROM country LIMIT 230, 10;

-- PREPARE STMT FROM 'SELECT * FROM country LIMIT ?';
-- EXECUTE STMT USING @pagePer;