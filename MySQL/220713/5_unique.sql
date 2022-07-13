CREATE TABLE persons (
    personId INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(10) NOT NULL,
    lastName VARCHAR(10) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE
);
DROP TABLE persons;
INSERT INTO persons (firstName, lastName, age, email)
VALUES ("길동", "홍", 20, "길동홍길동.net"), ("길동", "고", 42, "길동홍길동.net");
SELECT * FROM persons;
-- 테이블 이름
-- 각 열 (이름, 타입, 제약)
-- Key 열 (특정시켜줘야 한다)