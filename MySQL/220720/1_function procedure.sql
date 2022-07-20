-- 함수 (좁은 범위의 기능) (in out 이 값으로 정해져 있다)
SELECT hello('야야야');

-- 스토어드 프로시저 : 로직을 담을 수 있다. (다 된다)
-- 로직을 구현하는 방법 Java에서 로직을 갖고있는 객체로 전달하는, SQL에서 프로시저를 호출하는 방법 2가지
-- SQL로 로직을 구현할 때
-- 장점 : (캐싱) 이미 수행했던 작업은 다시 사용할 때 더 빨리 작업이 완료된다.
-- 단점 : 테스트가 엄청 힘들다. SQL로 작성해야 한다.
-- 프로시저 안에 지역변수를 사용할 수 있다. 선언 시 (DECLARE)
-- DECLARE sum INT DEFAULT 0; (선언과 초기화 동시)

-- SQL 반복문 사용 예제
-- 조건이 거짓일 때
-- 조건이 참이 될 때 ~까지 반복
-- REPEAT
-- 		SET sum = sum + i;
-- 		SET i = i + 1;
-- UNTIL i > num END REPEAT;

-- 조건이 참일 때 반복
-- WHILE i < num DO
-- 		SET sum = sum + i;
-- 		SET i = i + 1;
-- END WHILE;

CALL usp_countBooks();
CALL usp_findbytitle('책', @count);
SELECT @count;

CALL usp_selectTable('books');

CALL usp_loop(10, @var);
SELECT @var;