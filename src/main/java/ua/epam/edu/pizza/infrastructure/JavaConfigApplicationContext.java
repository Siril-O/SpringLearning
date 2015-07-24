package ua.epam.edu.pizza.infrastructure;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class JavaConfigApplicationContext implements ApplicationContext {

	private Config config;

	public JavaConfigApplicationContext(Config config) {

		this.config = config;
	}

	@Override
	public Object getBean(String beanName) throws Exception {

		Class<?> clazz = config.getImplementation(beanName);

		Constructor<?> constructor = clazz.getConstructors()[0];
		Class<?>[] parameters = constructor.getParameterTypes();
		if (parameters.length == 0) {
			return clazz.newInstance();
		} else {
			List<Object> params = new ArrayList<>();
			// Object[] params = new Object[parameters.length];
			for (Class<?> parameter : parameters) {
				String name = parameter.getSimpleName();
				// first letter not capital
				name = Character.toLowerCase(name.charAt(0))
						+ name.substring(1);
				params.add(getBean(name));
			}
			return constructor.newInstance(params.toArray());
		}
	}

}
