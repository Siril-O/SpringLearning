package ua.epam.edu.pizza.domain;


public class Pizza {

	private int id;
	private String name;
	private double price;
	private PizzaType type;
	
	
	
	public Pizza() {
		super();
	}
	public Pizza(int id, String name, double price, PizzaType type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the type
	 */
	public PizzaType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(PizzaType type) {
		this.type = type;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pizza [id=" + id + ", name=" + name + ", price=" + price
				+ ", type=" + type + "]";
	}
	
}
