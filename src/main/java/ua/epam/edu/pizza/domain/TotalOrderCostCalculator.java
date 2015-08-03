package ua.epam.edu.pizza.domain;

import java.util.Map;

public class TotalOrderCostCalculator {

	/*
	 * Order consist of from 1 t o10 pizzas Discount 30% on the most expensive
	 * pizza if amount of pizzas more than 4 Negative Test
	 */
	
	/*
	 *  test lower 4 
	 *	test  quantity  biger 4
	 *	test one most expensive Pizza
	 *	test two most Expensive Pizza 
	 */
	public double calculateTotalOrderPrice(Map<Pizza, Integer> pizzas) {

		int pizzaCount = 0;
		double totalPrice = 0;

		for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {

			int quantity = entry.getValue();
			if (quantity <= 0) {
				throw new IllegalArgumentException();
			}

			pizzaCount += quantity;
			totalPrice += entry.getKey().getPrice() * quantity;
		}

		if (pizzaCount < 1 || pizzaCount > 10) {
			throw new IllegalArgumentException();
		}

		return totalPrice;
	}
}
