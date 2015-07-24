package ua.epam.edu.pizza.infrastructure;

import java.util.HashMap;
import java.util.Map;

import ua.epam.edu.pizza.repository.TestOrderRepository;
import ua.epam.edu.pizza.repository.TestPizzaRepository;
import ua.epam.edu.pizza.service.SimpleOrderService;

public class JavaConfig implements Config {

	private final Map<String, Class<?>> map = new HashMap<>();

	{
		map.put("pizzaRepository", TestPizzaRepository.class);
		map.put("orderRepository", TestOrderRepository.class);
		map.put("orderService", SimpleOrderService.class);
	}

	public Class<?> getImplementation(String beanName) {

		return map.get(beanName);
	}

}
