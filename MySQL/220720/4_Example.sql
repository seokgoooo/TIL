/*
	부서 -- (employees.department_id -참-조-> departments.department_id)
	직책 -- (employees.job_id -참-조-> job.job_id)
	매니저 -- (departments.MANAGER_ID -참-조-> employees.employee_id)
	위치 -- (department_id.location_id -참-조-> locations.location_id)
    
	1. 모든 부서의 부서명과 관리자의 이름 조회
	2. 부서명이 IT로 시작하는 부서에서 근무하는 직원들의 이름과 부서명 조회.
    3. 모든 직원들의 이름과 직책(JOB_TITLE) 조회
    4. 직원의 해당 직책의 jobs테이블에 책정된 최대 연봉(MAX_SALARY) 이상의 연봉을 받는 직원이름, 현재연봉, 최대연봉 조회
    5. 부서의 (COUNTRY_ID)가 'US'인 부서에서 근무하는 직원명과 부서명 조회
*/
USE hr;
SELECT * FROM hr.departments;
SELECT * FROM hr.locations;
SELECT * FROM hr.countries;
SELECT * FROM hr.employees;
SELECT * FROM hr.jobs;

-- 1. 모든 부서의 부서명과 관리자의 이름 조회
SELECT * FROM departments A
LEFT JOIN locations B ON A.location_id = B.location_id
LEFT JOIN countries C ON B.country_id = C.country_id;

-- 2. 부서명이 IT로 시작하는 부서에서 근무하는 직원들의 이름과 부서명 조회.
SELECT B.first_name, B.last_name, A.department_name FROM departments A
INNER JOIN employees B ON A.department_id = B.department_id WHERE A.department_name LIKE 'IT%';

-- 3. 모든 직원들의 이름과 직책(JOB_TITLE) 조회
SELECT B.first_name, B.last_name, A.job_title FROM jobs A
INNER JOIN employees B ON A.job_id = B.job_id;

-- 4. 직원의 해당 직책의 jobs테이블에 책정된 최대 연봉(MAX_SALARY) 이상의 연봉을 받는 직원이름, 현재연봉, 최대연봉 조회
SELECT B.first_name, B.last_name, B.salary, A.max_salary FROM jobs A
INNER JOIN employees B ON A.job_id = B.job_id WHERE B.salary >= A.max_salary;

-- 5. 부서의 (COUNTRY_ID)가 'US'인 부서에서 근무하는 직원명과 부서명 조회
SELECT B.first_name, B.last_name, A.department_name FROM departments A
INNER JOIN employees B ON A.department_id = B.department_id
INNER JOIN locations C ON A.location_id = C.location_id WHERE C.country_id = 'US';