package ua.epam.edu.pizza.service;

import ua.epam.edu.pizza.domain.Customer;
import ua.epam.edu.pizza.domain.Order;

public interface OrderService {

	public Order placeNewOrder(Customer customer, Integer... pizzasID);

}