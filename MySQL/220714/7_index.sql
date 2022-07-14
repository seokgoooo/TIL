USE my_db;
SELECT * FROM my_db.test WHERE myStr = 'A';
-- Primary key의 또 다른 특성
-- Primary key는 index (색인) 을 가진다
-- 색인을 왜 why? 색인을 통해 정렬을 해서 검색할 때 빠르고 쉽게 찾아 준다.
-- 색인은 오른쪽의 Execution Plan 을 통해서 보면 파란색으로 나옴
-- index 가 아닌 경우는 빨간색으로 나오는데 속도가 느리다.
SELECT * FROM test WHERE myInt = 2;

-- 2가지 이상의 Column에 Primary key를 부여할 수 있다.
-- But, 모든 Column 마다 Primary key 값이 같아야 중복이라고 본다.
-- index는 1개 이다. Pk가 아무리 많더라도 ( --> 쌍으로 묶어서 본다는 이야기 )
SELECT * FROM my_db.pktest;

INSERT INTO pktest (myCol1, myCol2) VALUE ('1', '1');
INSERT INTO pktest (myCol1, myCol2) VALUE ('1', '2');
INSERT INTO pktest (myCol1, myCol2) VALUE ('2', '1');
INSERT INTO pktest (myCol1, myCol2) VALUE ('1', '1');	-- > X ( 중복 )