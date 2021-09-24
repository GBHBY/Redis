package com.example.redis.ustil;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * simple log
 *
 * @Author zhaoss
 */
public class GlobalLogger {

    private static final Logger log = LoggerFactory.getLogger(GlobalLogger.class);

    public static void info(String message) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        String fileName = stackTrace[2].getFileName();
        log.info(String.format("%s:%s:", fileName, methodName) + message);
    }

    public static void warn(String message) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        String fileName = stackTrace[2].getFileName();
        log.warn(String.format("%s:%s:", fileName, methodName) + message);
    }

    public static void error(String message, Object e) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        String fileName = stackTrace[2].getFileName();
        log.error(String.format("%s:%s:%s", fileName, methodName, message), e);
    }
}
