DROP DATABASE my_db;

CREATE DATABASE my_db;
USE my_db;
CREATE TABLE students (
	-- 주요 키 (PRIMARY KEY) : NOT NULL, UNIQUE
    number INT PRIMARY KEY,	-- Map의 KEY 역할부여 ( NOT NULL : NULL 값 X, 고유한 특성 (중복 X) ), TABLE 생성 시 무조건 하나 있다고 보면 된다.
    name VARCHAR(10),
    age INT,
    score DOUBLE
);
DESC students;
INSERT INTO students (number, name, age, score) VALUES (1234, "길동", 20, 3.3);
INSERT INTO students (number, name, age, score) VALUES (1235, "둘리", 30, 4.4);
INSERT INTO students (number, name, age, score) VALUES (1236, "길동", 20, 3.3);
SELECT * FROM students;