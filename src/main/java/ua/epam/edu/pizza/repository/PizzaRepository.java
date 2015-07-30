package ua.epam.edu.pizza.repository;

import ua.epam.edu.pizza.domain.Pizza;

public interface PizzaRepository {

	public  Pizza getPizzaByID(int id);

}