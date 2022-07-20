-- 1개의 row를 가진 table을 합쳐보자
-- UNION : 중복되는 행을 추가할 때는 DISTINCT (중복제거가 된다)
-- UNION ALL : 중복되는 행이라도 추가가 된다.
-- Column 순서와 개수를 맞춰주는 것이 중요하다.
SELECT 1, 2, 3
UNION
SELECT 4, 5, 6
UNION
SELECT 7, 8, 9
UNION ALL
SELECT 1, 2, 3;

SELECT * FROM my_db.books;
SELECT * FROM books WHERE price BETWEEN 1000 AND 10000
UNION ALL
SELECT * FROM books WHERE title LIKE '책%';