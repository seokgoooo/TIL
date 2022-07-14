-- 직원 이름(이름 + 성) 결합시킨 Full Name
-- 전화번호가 011로 시작하는 경우 '개인전화', 그 외의 경우 '내선 번호'라고 별명은 '분류' 조회
USE hr;
SELECT * FROM employees;
SELECT 
    CONCAT(FIRST_NAME, ' ', LAST_NAME) AS 'FULL NAME',
    CASE
        WHEN PHONE_NUMBER LIKE '011%' THEN '개인전화'
        ELSE '내선 번호'
    END AS '분류'
FROM
    employees;
    
-- NULL 일 때 CASE WHEN 문 대신 사용해서 쿼리 길이를 줄여주는 함수
SELECT ifnull(NULL, '대체값');
-- 값이 3개, 1번째 값이 NULL이면 2번째깞, 2번째 값도 NULL이면 3번째 값
SELECT ifnull(ifnull('첫번째값', '두번째값'), '세번째값');
-- 위 문장이랑 같은 기능을 수행하는 함수
SELECT coalesce("첫번째값", '두번째값', '세번째값');

-- 인자 2개가 같으면 NULL 다르면 첫번째 인자를 return
SELECT nullif('A', 'A');
SELECT nullif('A', 'B');