SHOW DATABASES;
-- hr 데이터 베이스 사용하기 명령어 작성
USE hr;
-- employees(직원) 테이블의 구조 (어떠한 컬럼이 있는지)를 조회해보세요.
DESC employees;
-- employees(직원) 테이블의 모든 행의 모든 열을 조회해보세요.
SELECT * FROM employees;
-- 직원 테이블의 First_Name(이름) 열의 값이 'John'인 직원 조회
SELECT * FROM employees WHERE FIRST_NAME LIKE 'John';
-- 직원 테이블의 Last_Name(성) 열의 값이 'John을 포함하는 값'인 직원 조회
SELECT * FROM employees WHERE LAST_NAME LIKE '%John%';
-- 직원 테이블의 First_Name(이름)의 값이 6글자인 직원 조회
SELECT * FROM employees WHERE FIRST_NAME LIKE '______';
-- 직원 테이블의 Salary(연봉) 열의 값이 10000 ~ 15000인 직원 조회
SELECT * FROM employees WHERE SALARY BETWEEN 10000 AND 15000;
-- 직원 테이블의 이름, 성, 연봉 컬럼과 연봉의 6%를 연산하여 'tax'라는 별명으로 조회.
SELECT FIRST_NAME, LAST_NAME, SALARY, (SALARY * 0.06) AS 'tax' FROM employees;