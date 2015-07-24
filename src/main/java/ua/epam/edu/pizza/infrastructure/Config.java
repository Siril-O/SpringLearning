package ua.epam.edu.pizza.infrastructure;

public interface Config {

	public Class<?> getImplementation(String beanName);
}
