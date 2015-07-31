package ua.epam.edu.pizza.repository;

import ua.epam.edu.pizza.domain.Order;

public interface OrderRepository {

	public void saveOrder(Order order);

}