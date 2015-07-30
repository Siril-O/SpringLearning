<<<<<<< HEAD
package ua.epam.edu.pizza.infrastructure;

public class ObjectFactory {

	private static ObjectFactory instance;
	private Config config = new JavaConfig();

	private ObjectFactory() {

	}

	public static ObjectFactory getInstance() {
		if (instance != null) {
			return instance;
		}
		instance = new ObjectFactory();
		return instance;
	}

	public Object createObject(String pizzaRepository)
			throws InstantiationException, IllegalAccessException {

		Class<?> clazz = config.getImplementation(pizzaRepository);
		return clazz.newInstance();
	}
}
=======
package ua.epam.edu.pizza.infrastructure;

public class ObjectFactory {

	private static ObjectFactory instance;
	private Config config = new JavaConfig();

	private ObjectFactory() {

	}

	public static ObjectFactory getInstance() {
		if (instance != null) {
			return instance;
		}
		instance = new ObjectFactory();
		return instance;
	}

	public Object createObject(String pizzaRepository)
			throws InstantiationException, IllegalAccessException {

		Class<?> clazz = config.getImplementation(pizzaRepository);
		return clazz.newInstance();
	}
}
>>>>>>> ece65ebb0b5e2a181d926de53a700b41251fd7e6
