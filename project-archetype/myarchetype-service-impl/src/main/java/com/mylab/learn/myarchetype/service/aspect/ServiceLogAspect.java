package com.mylab.learn.myarchetype.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Prints a message before every service operation.
     * 
     * @param joinPoint reference to the join point information: service
     *        and operation.
     * @param request DTO object to debug.
     */
    @Before("execution(public * com.mylab.learn.myarchetype.service.*Service.*(..)) && args(request)")
    public void doBeforeLog(JoinPoint joinPoint, Object request) {
        this.logger.debug("operation: {}, request: {}", joinPoint.getSignature().toShortString(),
                request);
    }

    /**
     * Prints a message after every service operation.
     * 
     * @param response DTO object to debug.
     */
    @AfterReturning(value = "execution(public * com.mylab.learn.myarchetype.service.*Service.*(..))", returning = "response")
    public void doAfterLog(Object response) {
        this.logger.debug("operation response: {}", response);
    }
}
