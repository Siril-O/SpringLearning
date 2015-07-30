package ua.epam.edu.pizza;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.epam.edu.pizza.domain.Customer;
import ua.epam.edu.pizza.domain.Order;
import ua.epam.edu.pizza.repository.PizzaRepository;
import ua.epam.edu.pizza.service.OrderService;

public class SpringPizzaApp {

	public static void main(String[] args) {

		ConfigurableApplicationContext repositoryContext = new ClassPathXmlApplicationContext(
				"repositoryContext.xml");

		ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "appContext.xml" }, repositoryContext);

		OrderService orderService = (OrderService) appContext
				.getBean("orderService");

		Customer customer = new Customer(0, "Customer 1");

		Order order = orderService.placeNewOrder(customer, 1, 2, 3);
		Order order2 = orderService.placeNewOrder(customer, 1, 2);

		System.out.println(order);
		System.out.println(order2);
		System.out.println(order==order2);
		
//		System.out.println(appContext.getBean(Order.class));
//		System.out.println(appContext.getBean(Order.class));
		// String[] definitionNames = appContext.getBeanDefinitionNames();
		//
		// for (String name : definitionNames) {
		// System.out.println(name);
		// }

		appContext.close();
		repositoryContext.close();	
	}

}
