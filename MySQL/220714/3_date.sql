SELECT * FROM employees;
DESC employees;
-- MySQL에서는 날짜 : date 타입
-- MySQL에서는 시간 : time 타입
-- MySQL에서는 날짜 시간 : datetime / timestamp

SELECT current_date();
SELECT current_time();
SELECT current_timestamp();

SELECT DATE '2022-07-14';
SELECT TIME '12:05:33';

-- HIRE_DATE가 1987년 6월인 직원들 목록
SELECT * FROM employees WHERE HIRE_DATE LIKE '1987-06%';
SELECT * FROM employees WHERE HIRE_DATE >= DATE '1987-06-01' AND HIRE_DATE <= DATE '1987-06-30';
SELECT * FROM employees WHERE HIRE_DATE BETWEEN '1987/06/01' AND '1987/06/30';

SELECT ADDDATE('1987-06-01', 1000);
SELECT SUBDATE('1987-06-01', 1000);
SELECT DATE_ADD('1987-06-01', INTERVAL 1000 DAY);
SELECT DATE_SUB('1987-06-01', INTERVAL 1000 MONTH);
-- 날짜 합연산을 할 때는 INTERVAL 으로 표현을 해주면 가능하다 그냥 INT 형으로는 안됨
SELECT '1987-06-01' + INTERVAL 1 YEAR;
SELECT '1987-06-30' + INTERVAL 1 DAY;

-- 1이 일요일이다 ~.~
SELECT dayofweek('2022-07-14');

SELECT extract(YEAR FROM '2022-07-14');
SELECT extract(MONTH FROM '2022-07-14');
SELECT extract(DAY FROM '2022-07-14');

-- 앞에서 뒤를 뺴서 일(day) 수 의 차이
SELECT datediff('2022-06-01', current_date());
-- MySQL은 문자열로 쓰더라도 날짜 형태로 알아서 알아먹어서 많이 쓸 필요가 없는데 다른 SQL에서는 쓸 일이 생길 수가 있다~~~~~
SELECT str_to_date('2021/06/13', '%Y/%m/%d');
SELECT date_format(DATE '2021-06-13', '%Y/%M/%D');

-- 17일에 고용된 직원 목록
SELECT * FROM employees WHERE extract(DAY FROM HIRE_DATE) = 17;
SELECT * FROM employees WHERE HIRE_DATE LIKE '%-17';

-- job_history 각 행별로 일한 '기간(일)' 조회
SELECT *, datediff(END_DATE, START_DATE) AS inter FROM job_history;

-- 자료형 숫자, 문자열, 날짜	형변환
SELECT CAST(10 AS TIME);
SELECT cast('10' AS DOUBLE) + 5.5;

SELECT CONVERT(10, TIME);
SELECT CONVERT('10', DOUBLE) + 5.5;