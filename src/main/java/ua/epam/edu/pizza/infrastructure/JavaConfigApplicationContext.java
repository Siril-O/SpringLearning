package ua.epam.edu.pizza.infrastructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class JavaConfigApplicationContext implements ApplicationContext {

	private final Config config;
	private final Map<String, Object> beans = new HashMap<>();

	public JavaConfigApplicationContext(Config config) {

		this.config = config;
	}

	@Override
	public Object getBean(String beanName) throws Exception {

		Object bean = beans.get(beanName);

		if (bean != null) {
			return bean;
		}
		BeanBuilder beanBuilder = new BeanBuilder(beanName);
		beanBuilder.createObject();
		beanBuilder.createProxy();
		beanBuilder.callInitMethod();

		return beanBuilder.getObject();

		// Class<?> clazz = config.getImplementation(beanName);
		//
		// Constructor<?> constructor = clazz.getConstructors()[0];
		// Class<?>[] parameters = constructor.getParameterTypes();
		// if (parameters.length == 0) {
		// bean = clazz.newInstance();
		// beans.put(beanName, bean);
		// return bean;
		// } else {
		// Object[] initArgs = new Object[parameters.length];
		// for (int i = 0; i < parameters.length; i++) {
		// String name = parameters[i].getSimpleName();
		// name = Character.toLowerCase(name.charAt(0))
		// + name.substring(1);
		// initArgs[i] = getBean(name);
		//
		// }
		// bean = constructor.newInstance(initArgs);
		// beans.put(beanName, bean);
		// return bean;
		// }
	}

	class BeanBuilder {

		Object obj;
		String beanName;

		public BeanBuilder(String beanName) {
			this.beanName = beanName;
		}

		public void createObject() throws Exception {

			Class<?> clazz = config.getImplementation(beanName);

			Constructor<?> constructor = clazz.getConstructors()[0];
			Class<?>[] parameters = constructor.getParameterTypes();
			if (parameters.length == 0) {
				obj = clazz.newInstance();
				beans.put(beanName, obj);
				return;
			} else {
				Object[] initArgs = new Object[parameters.length];
				for (int i = 0; i < parameters.length; i++) {
					String name = parameters[i].getSimpleName();
					name = Character.toLowerCase(name.charAt(0))
							+ name.substring(1);
					initArgs[i] = getBean(name);

				}
				obj = constructor.newInstance(initArgs);
				beans.put(beanName, obj);

			}
		}

		public void callInitMethod() throws Exception {
			Class<?> clazz = obj.getClass();
			Method method;
			try {
				method = clazz.getMethod("init");
			} catch (NoSuchMethodException ex) {
				return;
			}
			method.invoke(obj);
		}

		public Object getObject() {
			return obj;
		}

		public void createProxy() {
		}

	}

}
