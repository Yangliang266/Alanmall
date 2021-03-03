package com.itcrazy.alanmall.mscard.dataSource;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 切换数据源的AOP
 * @author chenfei
 * 2018-10-09
 */
//@Aspect
//@Order(1)
@Component
public class DataSourceAop implements MethodBeforeAdvice, AfterReturningAdvice {

//    // @within在类上设置
//    // @annotation在方法上进行设置
//    @Pointcut("@within(com.itcrazy.alanmall.mscard.dataSource.DynamicSwitchDataSource)||@annotation(com.itcrazy.alanmall.mscard.dataSource.DynamicSwitchDataSource)")
//    public void pointcut() {}
//
//    @Before("pointcut()")
//    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException, SecurityException {
//    	Signature signature =  joinPoint.getSignature();//方法签名
//        Method method = ( (MethodSignature)signature ).getMethod();
//
//        //这个方法才是目标对象上有注解的方法
//        Method realMethod = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(), method.getParameterTypes());
//        DynamicSwitchDataSource annotationClass = realMethod.getAnnotation(DynamicSwitchDataSource.class);//获取方法上的注解
//        if(annotationClass == null){
//            annotationClass = joinPoint.getTarget().getClass().getAnnotation(DynamicSwitchDataSource.class);//获取类上面的注解
//            if(annotationClass == null) return;
//        }
//        // 获取注解上的数据源的值的信息
//        DataSources dataSourceKey = annotationClass.dataSource();
//        if(dataSourceKey !=null){
//        	DynamicDataSource.clearCustomerType();
//            //给当前的执行SQL的操作设置特殊的数据源的信息
//        	DynamicDataSource.setCustomerType(dataSourceKey);
//        }
//    }

//    @After("pointcut()")
//    public void after(JoinPoint point) {
//        // 清理掉当前设置的数据源，让默认的数据源不受影响
//    	DynamicDataSource.clearCustomerType();
//    }

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		// 首先取类上的数据源
        if(method.getDeclaringClass().isAnnotationPresent(DynamicSwitchDataSource.class) &&
        		!method.isAnnotationPresent(DynamicSwitchDataSource.class)) {

        	DynamicSwitchDataSource datasource = method.getDeclaringClass().getAnnotation(DynamicSwitchDataSource.class);
            DynamicDataSource.setCustomerType(datasource.dataSource());

            // 方法上的数据源 优先级高于类上的
        } else if (method.isAnnotationPresent(DynamicSwitchDataSource.class)) {
        	DynamicSwitchDataSource datasource = method.getAnnotation(DynamicSwitchDataSource.class);
            DynamicDataSource.setCustomerType(datasource.dataSource());
        } else {
        	DynamicDataSource.setCustomerType(DataSources.CARD);
        }
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args,
			Object target) throws Throwable {
		// 清理掉当前设置的数据源，让默认的数据源不受影响
    	DynamicDataSource.clearCustomerType();
	}
}
