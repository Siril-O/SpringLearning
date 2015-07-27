package ua.epam.edu.pizza;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.epam.edu.pizza.domain.Customer;
import ua.epam.edu.pizza.domain.Order;
import ua.epam.edu.pizza.repository.PizzaRepository;
import ua.epam.edu.pizza.service.OrderService;

public class SpringPizzaApp {

	public static void main(String[] args) {

		ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(
				"appContext.xml");

		OrderService orderService = (OrderService) appContext.getBean("orderService");

		Customer customer = new Customer(0, "Customer 1");
		
		 Order order = orderService.placeNewOrder(customer, 1, 2, 3);
		 System.out.println(order);
//		String[] definitionNames = appContext.getBeanDefinitionNames();
//
//		for (String name : definitionNames) {
//			System.out.println(name);
//		}
		appContext.close();
	}

}
