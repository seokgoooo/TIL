CREATE TABLE books (
    bookId INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(30),
    price INT
);
DESC books;
INSERT INTO books (title, price) VALUES ("책1", 2000), ("책2", 3000), ("중복이름", 2500), ("중복이름", 3000);
INSERT INTO books (title, price) VALUES ("새로운이름", 3500);
SELECT * FROM books;
DELETE FROM books WHERE bookId = 3;