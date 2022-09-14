package kr.co.greenart.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);

//	접근제한자 리턴타입 패키지.클래스.메소드(파라미터) 순서
//	Before After execution이 겹치니까 Pointcut으로 하나로 나타내자 
	@Pointcut("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
	public void print() {
	}

	@Pointcut("within(@org.springframework.stereotype.Repository *)")
	public void repository() {
	}

	@Around("repository()")
	public Object loggingTime(ProceedingJoinPoint jp) throws Throwable {
		long start = System.nanoTime();
		logger.info("시작 시간 : " + start);

//		Object proceed = jp.proceed();
//		얘가 실제 실행되는 메소드 위에 적으면 Before 밑에 적으면 After		
		Object proceed = jp.proceed();

		long end = System.nanoTime();
		logger.info("종료 시간 : " + end);

		logger.info(jp.getSignature().getName() + " 메소드의 실행시간 : " + (end - start));
		return proceed;
	}

	@Before("print()")
	public void printBefore() {
		logger.info("-- 파일 목록을 불러 오기 전에 실행됩니다. --");
	}

	@After("print()")
	public void printAfter() {
		logger.info("-- 파일 목록을 불러온 후에 실행됩니다. --");
	}

//	@Before("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
//	public void printBefore() {
//		logger.info("-- 파일 목록을 불러 오기 전에 실행됩니다. --");
//	}
//
//	@After("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
//	public void printAfter() {
//		logger.info("-- 파일 목록을 불러온 후에 실행됩니다. --");
//	}
}
