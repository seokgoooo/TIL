-- 제약사항도 똑같이 복사되는 테이블을 만들고 싶으면 LIKE를 써준다.
-- 값을 복사하고 싶으면 INSERT INTO
CREATE TABLE persons_copy LIKE persons;

SELECT * FROM my_db.persons_copy;

SELECT * FROM my_db.persons;

INSERT INTO persons_copy (firstName, lastName, age, email)
SELECT firstName, lastName, age, email FROM persons;

-- 이런 방법도 있지만 값은 복사 되지만 제약사항이 다 들어가지 않는다.
CREATE TABLE persons_copy2
SELECT * FROM persons;

DESC persons_copy2;
SELECT * FROM persons_copy2;

-- DB에 테이블이 이것저것 생기면 더러워지기 때문에 임시로 사용할 테이블을 만드는것도 가능하다.
-- 왼쪽 스키마 목록에는 보이지 않는데 사용은 가능하다.
-- 임시의 범위는 접속을 끊으면 없어진다. (= 세션변수)
CREATE TEMPORARY TABLE mytable (
myNum int, myStr VARCHAR(100) );
SELECT * FROM mytable;