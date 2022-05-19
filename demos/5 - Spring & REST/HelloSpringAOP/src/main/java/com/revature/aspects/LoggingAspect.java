package com.revature.aspects;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.models.Anime;

/*Source: https://mkyong.com/spring3/spring-aop-aspectj-annotation-example/ */

@Aspect
@Component
public class LoggingAspect {
	private static Logger log = Logger.getLogger(LoggingAspect.class);
	
	@Before(value = "execution(* com.revature.*.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		log.info("Before advice for: [" + joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "]");
	}
	
	//@After(value = "execution(* com.revature.services.AnimeServiceImpl.getAllAnimeShows(..))")
	@After(value = "execution(* com.revature.*.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		log.info("After advice for: [" + joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "]");
	}
	
	@Around(value = "execution(* com.revature.services.*.*(..))")
	public Object logDuring(ProceedingJoinPoint joinPoint) throws Throwable {
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
