CREATE DATABASE my_db;

SHOW DATABASES;

USE my_db;

SHOW TABLES;

-- 사람 테이블
-- 열 1 : 이름 문자열
-- 열 2 : 나이 정수
CREATE TABLE persons (
    name VARCHAR(10),
    age INT
);
DESC persons;
SELECT * FROM persons;
INSERT INTO persons (name, age) VALUES ("홍길동", 22);
-- 순서를 바꿔도 된다 INSERT INTO persons (age, name) VALUES (22, "홍길동");
INSERT INTO persons (name, age) VALUES ("브루스 리", 30), ("스티븐 킹", 40);
INSERT INTO persons (name, age) VALUES ("철수", 20), ("철수", 30), ("철수", 40);
-- 테이블의 행 삭제
DELETE FROM persons;
-- 테이블 삭제
DROP TABLE persons;

-- 책 테이블 생성 (제목 : 문자열, 가격 : 정수)
CREATE TABLE book ( title VARCHAR(25), price INT );
DESC book;
SELECT * FROM book;
-- 파워자바, 25000
INSERT INTO book (title, price) VALUES ("파워자바", 25000);
INSERT INTO book (title, price) VALUES ("하늘과 바람과 별과 시", 15000), ("꽃을 보듯 너를 본다", 12000);

-- CHAR(5) : 'A    ' A 한글자만 쓰더라도 나머지는 공백으로 무조건 길이값을 5자리로 맞춤
-- VARCHAR(5) : 'A' A 한글자만 쓰더라도 그 길이값에 맞게 알아서 조절해줌

CREATE TABLE testChar ( fixLength CHAR(5), varLength VARCHAR(5) );
INSERT INTO testChar (fixLength, varLength) VALUES ('A', 'A');
SELECT fixLength, varLength FROM testChar;

-- 오른쪽 공백 제거 SELECT rtrim('A                 ');
-- 왼쪽 공백 제거 SELECT ltrim('                 A');