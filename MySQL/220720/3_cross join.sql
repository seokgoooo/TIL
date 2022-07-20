-- column 을 여러개 호출하면 CROSS JOIN(곱연산) 이 일어난다.

-- 메뉴의 restId와 레스토랑의 id 가 같을 때 만 붙여주고 싶을 때
-- LEFT JOIN : 왼쪽이 기준 RIGHT JOIN : 오른쪽이 기준
-- OUTER (생략가능) : 결합시킬 값이 없을 때 NULL 값이 들어간다.
-- INNER (생략가능) (LEFT RIGHT)가 없음 : 결합시킬 값이 없는 값은 삭제한다.

SELECT * FROM menus AS A
LEFT JOIN restaurants AS B ON A.restId = B.id;

SELECT * FROM menus AS A
RIGHT JOIN restaurants AS B ON A.restId = B.id;

SELECT * FROM menus AS A
INNER JOIN restaurants AS B ON A.restId = B.id;

SELECT * FROM restaurants AS A
LEFT OUTER JOIN menus AS B ON A.id = B.restId;

SELECT * FROM restaurants AS A
RIGHT OUTER JOIN menus AS B ON A.id = B.restId;

SELECT * FROM restaurants AS A
INNER JOIN menus AS B ON A.id = B.restId;

SELECT * FROM restaurants AS A
JOIN menus AS B ON A.id = B.restId;

SELECT * FROM my_db.books AS A
LEFT JOIN persons AS B ON A.owner = B.personId;

SELECT * FROM my_db.books AS A
JOIN persons AS B ON A.owner = B.personId;

SELECT A.*, B.firstName, B.lastName FROM my_db.books AS A
JOIN persons AS B ON A.owner = B.personId
WHERE A.price >= 10000;