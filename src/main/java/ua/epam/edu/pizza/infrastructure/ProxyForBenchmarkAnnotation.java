package ua.epam.edu.pizza.infrastructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyForBenchmarkAnnotation {
	
	public Object checkAndCreateProxyObjForBenchmarkAnnotation(Object obj) {
		Class<?> clazz = obj.getClass();
		for (Method m : clazz.getMethods()) {
			if (m.isAnnotationPresent(Benchmark.class)) {
				return obj = createProxyObj(obj);
			}
		}
		return obj;
	}

	private Object createProxyObj(final Object obj) {
		final Class<?> type = obj.getClass();

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
