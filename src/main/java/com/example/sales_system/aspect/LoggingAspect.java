package com.example.sales_system.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.example.sales_system.service.SaleService.update(..))")
    public void updateSalePointcut() {}

    @AfterReturning(pointcut = "updateSalePointcut()", returning = "result")
    public void logAfterUpdate(Object result) {
        logger.info("Sale updated: " + result);
    }
}
