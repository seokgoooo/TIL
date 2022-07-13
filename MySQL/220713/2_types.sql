-- 학생
-- 이름 : 가변길이문자열(10자)
-- 학점 : 실수

CREATE TABLE students (
    name VARCHAR(10),
    age INT,
    score DOUBLE
);
INSERT INTO students (name, age, score) VALUES ("길동", 20, 3.3);
INSERT INTO students (name, age, score) VALUES ("둘리", 20.5, 3);
INSERT INTO students (name, age, score) VALUES ("길동", 21, 2.6);

SELECT * FROM students;

DELETE FROM students WHERE Name = "둘리";