<<<<<<< HEAD
package ua.epam.edu.pizza.infrastructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BenchmarkBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		Class<?> clazz = bean.getClass();
		for (Method m : clazz.getMethods()) {
			if (m.isAnnotationPresent(Benchmark.class)) {
				System.out.println("Bean Class = " + bean.getClass().getName());
				System.out.println("Bean Class Interfaces = " + Arrays.toString(bean.getClass().getInterfaces()));
				System.out.println("Bean SuperClass = " + bean.getClass().getSuperclass().getName());
				System.out.println("Bean SuperClass Interfaces = "
						+ Arrays.toString(bean.getClass().getSuperclass().getInterfaces()));

				bean = new ProxyForBenchmarkAnnotation().checkAndCreateProxyObjForBenchmarkAnnotation(bean);

			}
		}
		return bean;
	}


}
=======
package ua.epam.edu.pizza.infrastructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

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

				bean = createProxyObj(bean);

			}
		}
		return bean;
	}

	private Object createProxyObj(final Object obj) {
		final Class<?> type = obj.getClass().getSuperclass();

		return Proxy.newProxyInstance(type.getClassLoader(),
				type.getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						Object retVal;

						if (type.getMethod(method.getName(),
								method.getParameterTypes())
								.isAnnotationPresent(Benchmark.class)) {

							System.out.println("Benchmark start: "
									+ method.getName());
							long start = System.nanoTime();
							retVal = method.invoke(obj, args);
							long result = System.nanoTime() - start;
							System.out.println(result);
							System.out.println("Benchmark finish: "
									+ method.getName());
						} else {
							retVal = method.invoke(obj, args);
						}
						return retVal;

					}
				});
	}

}
>>>>>>> ece65ebb0b5e2a181d926de53a700b41251fd7e6
