package ua.epam.edu.pizza.infrastructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

		final Class<?> type = obj.getClass();/*checkIfBeanWrapedForLookupMethod(obj)*/;

		 Set<Class<?>> interfaces = new HashSet<>();
		 interfaces.addAll(Arrays.asList(type.getInterfaces()));
		 interfaces.addAll(Arrays.asList(type.getSuperclass().getInterfaces()));
		 
		 Class<?>[] interfaceArray =  interfaces.toArray(new Class[0]);
		//Class<?>[] interfaceArray = type.getInterfaces();

		return Proxy.newProxyInstance(type.getClassLoader(), interfaceArray, new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object retVal;

				if (type.getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(Benchmark.class)) {

					System.out.println("Benchmark start: " + method.getName());
					long start = System.nanoTime();
					retVal = method.invoke(obj, args);
					long result = System.nanoTime() - start;
					System.out.println(result);
					System.out.println("Benchmark finish: " + method.getName());
				} else {
					retVal = method.invoke(obj, args);
				}
				return retVal;

			}
		});
	}

	private Class<?> checkIfBeanWrapedForLookupMethod(final Object obj) {
		Class<?> type;
		type = obj.getClass();

		for (Class<?> c : obj.getClass().getInterfaces()) {
			if (c.getName().equals("org.springframework.cglib.proxy.Factory")) {
				type = obj.getClass().getSuperclass();
				break;
			}
		}
		return type;
	}

}
