package az.msproductservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Around("execution(* az.msproductservice.controller..*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(
                "ActionLog.{}() with argument[s] = {} ",
                joinPoint.getSignature().getName(),
                joinPoint.getArgs()
        );
        try {
            Object result = joinPoint.proceed();
            log.info(
                    "ActionLog.{}() with result = {}",
                    joinPoint.getSignature().getName(),
                    result
            );
            return result;
        } catch (IllegalArgumentException e) {
            log.error(
                    "Illegal argument: {} in {}()",
                    joinPoint.getArgs(),
                    joinPoint.getSignature().getName()
            );
            throw e;
        }
    }
}
