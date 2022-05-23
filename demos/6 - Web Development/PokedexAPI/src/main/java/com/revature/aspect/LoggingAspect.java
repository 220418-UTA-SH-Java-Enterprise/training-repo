package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static Logger log = Logger.getLogger(LoggingAspect.class);
	
	@Before(value = "execution(* com.revature.*.*.*(..)) && !@annotation(com.revature.security.NoLogging)")
	public void logBefore(JoinPoint joinPoint) {
		log.info("Before advice for: [" + joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "]");
	}
	
	//@After(value = "execution(* com.revature.services.AnimeServiceImpl.getAllAnimeShows(..))")
	@After(value = "execution(* com.revature.*.*.*(..)) && !@annotation(com.revature.security.NoLogging)")
	public void logAfter(JoinPoint joinPoint) {
		log.info("After advice for: [" + joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "]");
	}
	
	@Around(value = "execution(* com.revature.service.*.*(..)) && !@annotation(com.revature.security.NoLogging)")
	public Object logDuringService(ProceedingJoinPoint joinPoint) throws Throwable {
		//1. get the arguments returned from the dao layer
		log.info("Around advice for: [" + joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "]");
		
		Object[] args = joinPoint.getArgs();
		
		//3. proceed the joinpoint
		Object result = joinPoint.proceed(args);
		log.info("Result of this method invoking is: " + result);
		
		//end the advice
		log.info("End of Around Advice");
		return result;
	}
}
