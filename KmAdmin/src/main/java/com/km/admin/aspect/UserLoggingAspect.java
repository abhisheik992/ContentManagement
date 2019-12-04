package com.km.admin.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class UserLoggingAspect {
	
	private static final Logger logger = LogManager.getLogger(UserLoggingAspect.class);
	
	@Before("execution(public String addFile())")
	public void beforeAddFile() {
		logger.info("=====>>>>>>>>Executing Before AddFile Method in Aspect===>>>>>>> ");
	}

}
