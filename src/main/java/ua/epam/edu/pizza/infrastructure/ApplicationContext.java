package ua.epam.edu.pizza.infrastructure;

public interface ApplicationContext {

	public Object getBean(String beanName) throws Exception;

}
