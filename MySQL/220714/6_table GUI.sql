USE my_db;
DESC books;
ALTER TABLE books CHANGE COLUMN title title VARCHAR(30) NOT NULL;

INSERT INTO books (title) VALUES ('디폴터값확인');
SELECT * FROM books;