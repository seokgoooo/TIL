SELECT * FROM my_db.books;

INSERT INTO books (title, price) VALUES ('테스트합니다', 4040);

INSERT INTO books (title, price) VALUES ('파란불껐음', 3333);



START TRANSACTION;

UPDATE books
SET price = 2000;

SELECT * FROM books;

ROLLBACK;
COMMIT;