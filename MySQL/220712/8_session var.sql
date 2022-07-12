-- 세션(Session) 변수(Variable)
-- 접속을 유지하는 동안 값이 저장되어 있다
SET @myVar := 10;

SELECT @myVar * 10 + 5;