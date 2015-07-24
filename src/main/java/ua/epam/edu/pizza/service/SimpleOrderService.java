package ua.epam.edu.pizza.service;

import java.util.ArrayList;
import java.util.List;

import ua.epam.edu.pizza.domain.Customer;
import ua.epam.edu.pizza.domain.Order;
import ua.epam.edu.pizza.domain.Pizza;
import ua.epam.edu.pizza.repository.OrderRepository;
import ua.epam.edu.pizza.repository.PizzaRepository;
import ua.epam.edu.pizza.infrastructure.ObjectFactory;

public class SimpleOrderService implements OrderService {

	//private ObjectFactory objectFactory = ObjectFactory.getInstance();

	private PizzaRepository pizzaRepository;
	private OrderRepository orderRepository;
	

	public SimpleOrderService(PizzaRepository pizzaRepository, OrderRepository orderRepository) throws Exception {
		super();
		this.pizzaRepository = pizzaRepository;
		this.orderRepository = orderRepository;
//		pizzaRepository = (PizzaRepository) objectFactory
//				.createObject("pizzaRepository");
//		orderRepository = (OrderRepository) objectFactory
//				.createObject("orderRepository");
	}

	public Order placeNewOrder(Customer customer, Integer... pizzasID) {
		List<Pizza> pizzas = new ArrayList<Pizza>();

		for (Integer id : pizzasID) {
			pizzas.add(pizzaRepository.getPizzaByID(id)); 
		}
		Order newOrder = new Order(customer, pizzas);

		orderRepository.saveOrder(newOrder); 
		return newOrder;
	}

}
