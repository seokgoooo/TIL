SELECT * FROM employees;

SELECT rtrim('a      ');
SELECT ltrim('      a');
SELECT trim('      a       ');

SELECT lower('ABCDE');
SELECT upper('abcde');

SELECT reverse('qwer');

SELECT concat('문자열', '결합', '함수');
SELECT concat('결합', NULL, '값이 있으면?');

SELECT char_length('문자열길이');

-- ('보여줄 문자열', '찾는 문자열', '바꾸는 문자열')
SELECT replace('원본 문자열에서 변환합니다', '변환', 'REPLACE');
SELECT replace(123415162344, 234, 'REPLACE');

-- (문자열, 자를 시작 위지)
SELECT substring('employees', 5);
-- (문자열, 자를 시작 위지, 자를 개수)
SELECT substring('employees', 5, 2);
-- (문자열, - (음수) 일 때는 자를 시작 위지가 역순)
SELECT substring('employees', -3);
-- (문자열, - (음수) 일 때는 자를 시작 위지가 역순, 자를 개수)
SELECT substring('employees', -3, 2);

-- 왼쪽을 채워주고 오른쪽을 채워준다 (문자열, 원하는 사이즈, 넣을 문자열)
SELECT lpad('123', 5, '0');
SELECT rpad('456', 5, '*');
SELECT repeat('반복결합', 3);

SELECT locate('D', 'ABCDEFGD');
SELECT locate('D', 'ABCDEFGD', 5);
SELECT locate('D', 'ABCDEFGD', locate('D', 'ABCDEFGD') + 1);
-- SELECT locate('위치', '문자열의 위치를 찾는데 SQL의 문자 순서(index)는 1부터 센다~', '찾기 시작할 순서 정해주려면 여기에 index');

-- '515.123.4567' 을 . 기준으로 각각 잘라보자
SELECT substring('515.123.4567', 1, 3);
SELECT substring('515.123.4567', 5, 3);
SELECT substring('515.123.4567', -4, 4);

-- 직원 테이블 전화번호 앞자리 3자리로 그룹지어 개수
SELECT substring(PHONE_NUMBER, 1, 3), count(*) FROM employees GROUP BY SUBSTRING(PHONE_NUMBER, 1, 3);
SELECT substring(PHONE_NUMBER, 1, locate('.', PHONE_NUMBER) - 1), count(*) FROM employees GROUP BY SUBSTRING(PHONE_NUMBER, 1, locate('.', PHONE_NUMBER) - 1);

-- 숫자함수
SELECT rand();	-- 랜덤
SELECT round(123.123, 2);	-- 반올림
SELECT floor(2.555);	-- 버림
SELECT ceil(-3.222);	-- 올림

SELECT abs(-55);	-- 절대값
SELECT pow(2, 8);	-- 제곱
SELECT pi();

-- 주사위 1 ~ 6 사이의 난수(정수) 생성
SELECT ceil(rand() * 6);