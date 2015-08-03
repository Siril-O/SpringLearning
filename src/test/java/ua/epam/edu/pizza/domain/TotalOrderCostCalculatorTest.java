package ua.epam.edu.pizza.domain;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class TotalOrderCostCalculatorTest {

	private static final double DELTA = 0.005;

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateTotalOrderPricePizzasInOrderQuantityLimitsOutOfRangeThrowException() {
		Map<Pizza, Integer> map = new HashMap<>();
		TotalOrderCostCalculator calculator = new TotalOrderCostCalculator();
		calculator.calculateTotalOrderPrice(map);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateTotalOrderPriceQuantityOfPizzasLessThanOneThrowException() {
		Map<Pizza, Integer> map = new HashMap<>();
		map.put(new Pizza(), 0);
		TotalOrderCostCalculator calculator = new TotalOrderCostCalculator();
		calculator.calculateTotalOrderPrice(map);

	}
	
	
	@Test
	public void testCalculateTotalOrderWithOnePizza() {
		/*
		 * Prepare data and expected result
		 */
		Map<Pizza, Integer> map = new HashMap<>();
		double pizzaPrice = 23.5;
		map.put(new Pizza(1, "Margo", pizzaPrice, PizzaType.Meat), 1);
		double expectedPrice = 23.5;
		
		/*
		 * Testing
		 */
		TotalOrderCostCalculator calculator = new TotalOrderCostCalculator();
		double price = calculator.calculateTotalOrderPrice(map);

		
		/*
		 * compare expected and real
		 */
		
		//assertThat(price, is(closeTo(expectedPrice, 0.03)));
		assertEquals(expectedPrice, price, DELTA );
	}

}
