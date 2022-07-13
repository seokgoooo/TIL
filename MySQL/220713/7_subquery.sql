USE hr;
-- hr 부서 (departments) 테이블 모든 행과 열 조회
SELECT * FROM departments;
-- 부서 명이 'IT%'로 시작하는 부서들 조회
SELECT * FROM departments WHERE DEPARTMENT_NAME LIKE 'IT%';
-- 60, 210, 230
-- 직원 테이블
SELECT * FROM employees WHERE DEPARTMENT_ID IN (60, 210, 230);
-- 위 아래는 같은 의미의 문장.
SELECT * FROM employees WHERE DEPARTMENT_ID IN (
-- 괄호 안에 있는 문장을 서브쿼리라고 부름.
SELECT DEPARTMENT_ID FROM departments WHERE DEPARTMENT_NAME LIKE 'IT%'
);

-- 연봉 내림차순 정렬.
SELECT * FROM employees ORDER BY SALARY DESC;
-- 연봉 탑 10을 보는데 // 연봉을 오름차순으로 조회. (테이블에 별명 붙이기)
SELECT * FROM (
SELECT * FROM employees ORDER BY SALARY DESC LIMIT 10
) AS A ORDER BY SALARY ASC;
-- (컬럼에 서브쿼리 붙이기)
SELECT (SELECT 1 + 1), 2, 3, 4;
-- David Austin의 연봉과 같은 연봉을 받는 직원들 조회
SELECT * FROM employees WHERE FIRST_NAME = 'David' AND LAST_NAME = 'Austin';

SELECT * FROM employees WHERE SALARY = (
SELECT SALARY FROM employees WHERE FIRST_NAME = 'David' AND LAST_NAME = 'Austin'
);