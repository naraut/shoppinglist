package com.test.shoppingcart;

import static java.util.Arrays.asList;
import java.util.List;

public class Product {
	
	public enum Offer {
		
		NA, BOGOF, ThreeForTwo;
	}
	
    private String name;
    private double price;
    private Offer offer;
        
    public Product(String name, double price, Offer offer) {
		super();
		this.name = name;
		this.price = price;
		this.offer = offer;
	}
	
    public static final List<Product> inventory =
            asList( new Product("apple", 0.35d, Offer.NA),
            		new Product("bananas", 0.20d, Offer.NA),
            		new Product("melons", 0.50d, Offer.BOGOF),
            		new Product("limes", 0.15d, Offer.ThreeForTwo));   
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}	
}