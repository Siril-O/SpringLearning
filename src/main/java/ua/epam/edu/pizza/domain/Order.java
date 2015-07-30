package ua.epam.edu.pizza.domain;

import java.util.Date;
import java.util.List;

public class Order {
	
	
	private int id;
	private List<Pizza> pizzas;
	private Customer customer;
	private String name;

	public Order(Customer customer, List<Pizza> pizzas) {
		this.pizzas = pizzas;
		this.customer = customer;
	}

	public Order() {
		super();
		name = new Date().toLocaleString();
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", pizzas=" + pizzas + ", customer="
				+ customer + ", name=" + name + "]";
	}

	public void destroy(){
		System.out.println("Destroy");
	}
}
