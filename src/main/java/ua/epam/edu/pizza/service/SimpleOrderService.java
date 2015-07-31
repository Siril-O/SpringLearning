package ua.epam.edu.pizza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import ua.epam.edu.pizza.domain.Customer;
import ua.epam.edu.pizza.domain.Order;
import ua.epam.edu.pizza.domain.Pizza;
import ua.epam.edu.pizza.repository.OrderRepository;
import ua.epam.edu.pizza.repository.PizzaRepository;
import ua.epam.edu.pizza.infrastructure.Benchmark;
import ua.epam.edu.pizza.infrastructure.ObjectFactory;

public class SimpleOrderService implements OrderService
//, ApplicationContextAware 
{

	// private ObjectFactory objectFactory = ObjectFactory.getInstance();

	//private ApplicationContext appContext;
	private PizzaRepository pizzaRepository;
	private OrderRepository orderRepository;

	public SimpleOrderService(PizzaRepository pizzaRepository,
			OrderRepository orderRepository) throws Exception {
		super();
		this.pizzaRepository = pizzaRepository;
		this.orderRepository = orderRepository;
		// pizzaRepository = (PizzaRepository) objectFactory
		// .createObject("pizzaRepository");
		// orderRepository = (OrderRepository) objectFactory
		// .createObject("orderRepository");
	}


	@Override
	public Order placeNewOrder(Customer customer, Integer... pizzasID) {
		List<Pizza> pizzas = new ArrayList<Pizza>();

		for (Integer id : pizzasID) {
			pizzas.add(pizzaRepository.getPizzaByID(id));
		}
		Order newOrder = getNewOrder();
		newOrder.setCustomer(customer);
		newOrder.setPizzas(pizzas);

		orderRepository.saveOrder(newOrder);
		return newOrder;
	}

	protected Order getNewOrder() {
//		Order newOrder = appContext.getBean("order", Order.class);
//		return newOrder;
		return null;
	}

//	@Override
//	public void setApplicationContext(ApplicationContext ac)
//			throws BeansException {
//		this.appContext = ac;
//	}

}
