<<<<<<< HEAD
package ua.epam.edu.pizza.repository;

import java.util.ArrayList;
import java.util.List;

import ua.epam.edu.pizza.domain.Order;
import ua.epam.edu.pizza.infrastructure.Benchmark;

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
	@Override
	public void saveOrder(Order order) {

		order.setId(orders.size() + 1);
		orders.add(order);
	}

}
=======
package ua.epam.edu.pizza.repository;

import java.util.ArrayList;
import java.util.List;

import ua.epam.edu.pizza.domain.Order;
import ua.epam.edu.pizza.infrastructure.Benchmark;

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
	@Override
	public void saveOrder(Order order) {

		order.setId(orders.size() + 1);
		orders.add(order);
	}

}
>>>>>>> ece65ebb0b5e2a181d926de53a700b41251fd7e6
