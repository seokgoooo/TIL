-- 부서 id가 90인 직원들의 인원 수
SELECT count(*) FROM employees WHERE DEPARTMENT_ID = 90;
-- 부서 id 60
SELECT count(*) FROM employees WHERE DEPARTMENT_ID = 60;
-- 부서 id 30
SELECT count(*) FROM employees WHERE DEPARTMENT_ID = 30;
-- 이렇게 부서별로 보고 싶을 때 하나하나씩 해주려면 상당히 귀찮다.
-- 그래서 그룹을 지어보자	GROUP BY - 집계함수랑 짝꿍
-- 부서별로 (그룹) 직원들의 인원 수
SELECT DEPARTMENT_ID, count(*) FROM employees GROUP BY DEPARTMENT_ID;


-- 부서별 최고 연봉, 최저 연봉, 평균 연봉, 연봉 합
SELECT 
    DEPARTMENT_ID,
    MAX(SALARY),
    MIN(SALARY),
    AVG(SALARY),
    SUM(SALARY)
FROM
    employees
GROUP BY DEPARTMENT_ID;

-- 집계함수랑 사용하지 않는 경우도 있다.
SELECT JOB_ID, LAST_NAME FROM employees GROUP BY JOB_ID;


-- DISTINCT 중복제거 (조회하고자 하는 컬럼의 행의 값이 똑같아야함)
SELECT DISTINCT JOB_ID, LAST_NAME FROM employees;


-- 직원 테이블 LAST_NAME을 중복 제거하고 조회
SELECT DISTINCT LAST_NAME FROM employees;


-- 직원 테이블 LAST_NAME 그룹 별로 인원 수 조회
SELECT LAST_NAME, count(*) FROM employees GROUP BY LAST_NAME;


-- LAST_NAME 그룹의 카운트가 2이상인 행들만 조회
-- GROUP BY에 조건을 걸고 싶으면 WHERE 대신 HAVING ~~~
SELECT LAST_NAME, COUNT(*) FROM employees GROUP BY LAST_NAME HAVING COUNT(*) > 1;


-- 위의 성을 가지는 직원 목록 조회
SELECT * FROM employees
WHERE
    LAST_NAME IN (SELECT LAST_NAME FROM employees GROUP BY LAST_NAME HAVING COUNT(*) > 1);
    
*****-- 헤비 유저가 소유한 장소 -- (프로그래머스) : 특정한 컬럼의 개수가 2개 이상인 조건이 있고 전체 TABLE을 보고 싶을 때 *****
SELECT * FROM PLACES WHERE HOST_ID IN (SELECT HOST_ID FROM PLACES GROUP BY HOST_ID HAVING COUNT(*) > 1);


-- 5번째로 적게 받는 직원들 목록
SELECT * FROM employees
WHERE
    SALARY = (SELECT DISTINCT SALARY FROM employees ORDER BY SALARY LIMIT 1 OFFSET 4);
    
    
-- 상위 연봉 50명 (같은 연봉에 대해서 FIRST_NAME이 빠른 친구)에 대해서 부서별로 몇 명씩 있는지
-- 서브쿼리를 Table로 쓸 때는 꼭 별명을 붙이자
SELECT 
    DEPARTMENT_ID, COUNT(*)
FROM (SELECT * FROM employees ORDER BY SALARY DESC LIMIT 50) AS A
GROUP BY DEPARTMENT_ID;
