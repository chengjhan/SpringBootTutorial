package tw.com.skl.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class DemoAspect {

	// 配置切點
	@Pointcut(value = "execution(* tw.com.skl.demo.controller.*.*(..))")
	public void pointCut() {

	}

	@Before(value = "pointCut()")
	public void doBefore(JoinPoint joinPoint) {

		String packageName = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();

		System.out.println(packageName + "." + methodName + "(): Start...");
	}

	@After(value = "pointCut()")
	public void doAfter(JoinPoint joinPoint) {

		String packageName = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();

		System.out.println(packageName + "." + methodName + "(): End...");
	}

}
