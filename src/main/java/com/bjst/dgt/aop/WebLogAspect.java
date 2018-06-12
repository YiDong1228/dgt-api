package com.bjst.dgt.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * aop日志切面 使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
 *
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {
	// ThreadLocal<Long> startTime = new ThreadLocal<>();1、优化- AOP切面中的同步问题
	ThreadLocal<Long> startTime = new ThreadLocal<>();
	private static final Logger log = LoggerFactory.getLogger(WebLogAspect.class);

	/**
	 * 使用@Pointcut定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。
	 * public表示访问权限是公有方法，第一个*表示返回类型，第二 *表示类名，第三个*表示方法(..)表示任何参数，包含子包
	 *
	 */
	@Pointcut("execution(public * com.bjst.dgt.web..*.*(..))")
	public void webLog() {
	}

	/*
	 * 本来准备AOP记录每个登陆，修改，增加，删除，操作，但是由于要记录返回参数和传入参数，还要判断操作的类型，而且切点表达式太长，太不方便了，
	 * 所以硬编码
	 * 
	 * @Pointcut("execution(public * cn.edu.jxnu.base.controller.admin.LoginController.login(..) || 太长"
	 * ) public void memorandumAop() {
	 * 
	 * }
	 * 
	 * @AfterReturning(value = "memorandumAop()",returning="object") public void
	 * afterMemorandum(JoinPoint point,Object object) {
	 * 
	 * 
	 * }
	 */

	/**
	 * 使用@Before在切入点开始处切入内容</br>
	 * i的值越小，优先级越高。在切入点前的操作，按order的值由小到大执行,在切入点后的操作，按order的值由大到小执行
	 *
	 */
	@Order(5)
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		startTime.set(System.currentTimeMillis());
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容，包含：url,请求方法，ip，类方法，参数
		log.info("URL : " + request.getRequestURL().toString());
		log.info("HTTP_METHOD : " + request.getMethod());
		log.info("IP : " + request.getRemoteAddr());
		log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

	}

	/**
	 * 使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
	 *
	 */
	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		log.info("RESPONSE : " + ret);
		log.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
	}

	/**
	 * 使用@After在切入点结尾处切入内容

	 */
	@After(value = "webLog()")
	public void doAfter(JoinPoint joinPoint) {
		// 处理完请求，返回内容
		log.info("FINISH : " + joinPoint.getClass());

	}
	// 使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑

}