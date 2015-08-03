package ua.epam.edu.pizza.infrastructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BenchmarkBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {

		Class<?> clazz = bean.getClass();
		for (Method m : clazz.getMethods()) {
			if (m.isAnnotationPresent(Benchmark.class)) {
				System.out.println("Bean Class = " + bean.getClass().getName());
				System.out.println("Bean Class Interfaces = "
						+ Arrays.toString(bean.getClass().getInterfaces()));
				System.out.println("Bean SuperClass = "
						+ bean.getClass().getSuperclass().getName());
				System.out.println("Bean SuperClass Interfaces = "
						+ Arrays.toString(bean.getClass().getSuperclass()
								.getInterfaces()));

				bean = new ProxyForBenchmarkAnnotation().checkAndCreateProxyObjForBenchmarkAnnotation(bean);

			}
		}
		return bean;
	}

}
