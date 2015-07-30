package ua.epam.edu.pizza.repository;

import java.util.Arrays;
import java.util.List;

import ua.epam.edu.pizza.domain.Pizza;
import ua.epam.edu.pizza.domain.PizzaType;
import ua.epam.edu.pizza.infrastructure.Benchmark;

public class TestPizzaRepository implements PizzaRepository {

	private List<Pizza> pizzas;

	public TestPizzaRepository() {
		super();
	}

	public void init() {
		pizzas = Arrays.asList(new Pizza(1, "Salami", 100.3, PizzaType.Meat),
				new Pizza(2, "Seal", 200.45, PizzaType.Sea), new Pizza(3,
						"Tomato", 200.45, PizzaType.Vegetarian));

	}

	/**
	 * @return the pizzas
	 */
	public List<Pizza> getPizzas() {
		return pizzas;
	}

	/**
	 * @param pizzas
	 *            the pizzas to set
	 */
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	@Benchmark
	public Pizza getPizzaByID(int id) {
		for (Pizza pizza : pizzas) {
			if (pizza.getId() == id) {
				return pizza;
			}
		}
		return null;
	}

}
