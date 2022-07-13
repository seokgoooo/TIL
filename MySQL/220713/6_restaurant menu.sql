CREATE TABLE restaurants (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(15) NOT NULL,
    phone VARCHAR(14) NOT NULL UNIQUE,
    address VARCHAR(100) NOT NULL UNIQUE	-- 주소든 전화번호든 최대한 쪼개놓으면 데이터 활용할 때 편하다 ( 시, 구, 동 등등 )
);
INSERT INTO restaurants (name, phone, address) VALUES ("대모골", "051-803-3109", "부산 부산진구 부전로152번길 71")
, ("도연정", "051-805-0071", "부산 부산진구 새싹로 16");
SELECT * FROM restaurants;
DROP TABLE restaurants;

CREATE TABLE menus (
    menuId INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(15) NOT NULL,
    price INT NOT NULL
);
INSERT INTO menus (name, price) VALUES ("숯불고추장구이", 16000), ("숯불간장구이", 16000), ("칼국수", 4000), ("칼국수", 3500);
SELECT * FROM menus;
DROP TABLE menus;

ALTER TABLE menus ADD COLUMN restId INT;
UPDATE menus SET restId = 2 WHERE menuId <> 1;

-- 외래키 : 다른 테이블을 참조하는 Column
-- 외래키 이름 짓는 방법 : 보통 (fk_해당 테이블 이름_참조하고자 하는 테이블 이름_숫자)
ALTER TABLE menus ADD CONSTRAINT FOREIGN KEY (restId) REFERENCES restaurants (id);
DESC menus;

-- Database - Reverse Engineer (Ctrl + R) --> EER Diagram 표현가능 (회사가서 이거부터 보면 데이터베이스 구조를 파악하고 시작할 수 있다.)