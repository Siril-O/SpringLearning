package ua.epam.edu.pizza.repository;

import java.util.ArrayList;
import java.util.List;

import ua.epam.edu.pizza.domain.Order;

public class TestOrderRepository implements OrderRepository {

	private List<Order> orders = new ArrayList<Order>();

	public TestOrderRepository() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ua.epam.edu.pizza.repository.OrderRepository#saveOrder(ua.epam.edu.pizza
	 * .domain.Order)
	 */
	public void saveOrder(Order order) {

		order.setId(orders.size() + 1);
		orders.add(order);
	}

}
