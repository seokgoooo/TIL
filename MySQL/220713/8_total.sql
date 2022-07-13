-- 집계 함수
SELECT * FROM employees;
-- count() 안에는 보통 * 을 쓴다. (null 값을 가지는 데이터가 있으면 count에 영향을 준다.)
SELECT count(*) FROM employees;
-- 전화번호가 515~ 로 시작하는 직원을 조회
SELECT * FROM employees WHERE PHONE_NUMBER LIKE '515%';
-- 전화번호가 515~ 로 시작하는 직원의 수를 조회
SELECT count(*) FROM employees WHERE PHONE_NUMBER LIKE '515%';
-- 합
SELECT sum(SALARY) FROM employees;
-- 평균
SELECT avg(SALARY) FROM employees;
-- 최대
SELECT MAX(SALARY) FROM employees;
-- 최소
SELECT MIN(SALARY) FROM employees;
-- 최대 연봉과 최소 연봉의 차를 구해봅시다.
SELECT MAX(SALARY) - MIN(SALARY) FROM employees;