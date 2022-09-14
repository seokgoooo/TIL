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

//	���������� ����Ÿ�� ��Ű��.Ŭ����.�޼ҵ�(�Ķ����) ����
//	Before After execution�� ��ġ�ϱ� Pointcut���� �ϳ��� ��Ÿ���� 
	@Pointcut("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
	public void print() {
	}

	@Pointcut("within(@org.springframework.stereotype.Repository *)")
	public void repository() {
	}

	@Around("repository()")
	public Object loggingTime(ProceedingJoinPoint jp) throws Throwable {
		long start = System.nanoTime();
		logger.info("���� �ð� : " + start);

//		Object proceed = jp.proceed();
//		�갡 ���� ����Ǵ� �޼ҵ� ���� ������ Before �ؿ� ������ After		
		Object proceed = jp.proceed();

		long end = System.nanoTime();
		logger.info("���� �ð� : " + end);

		logger.info(jp.getSignature().getName() + " �޼ҵ��� ����ð� : " + (end - start));
		return proceed;
	}

	@Before("print()")
	public void printBefore() {
		logger.info("-- ���� ����� �ҷ� ���� ���� ����˴ϴ�. --");
	}

	@After("print()")
	public void printAfter() {
		logger.info("-- ���� ����� �ҷ��� �Ŀ� ����˴ϴ�. --");
	}

//	@Before("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
//	public void printBefore() {
//		logger.info("-- ���� ����� �ҷ� ���� ���� ����˴ϴ�. --");
//	}
//
//	@After("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
//	public void printAfter() {
//		logger.info("-- ���� ����� �ҷ��� �Ŀ� ����˴ϴ�. --");
//	}
}
