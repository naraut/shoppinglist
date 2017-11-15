package com.test.shoppingcart;

import static java.util.stream.Collectors.summingDouble;

import java.util.ArrayList;
import java.util.List;

import com.test.shoppingcart.pricing.DiscountPricing;

public class ShoppingBasket {
	
	private final List<Product> shoppingList = new ArrayList<>();
	
	public void addToShoppingList(Product product) {		
		shoppingList.add(product);	
	}
		
	
	public void priceBasket() {		
		double totalWithoutDiscount =  shoppingList.stream()
				  .collect((summingDouble(Product::getPrice)));			  
		System.out.println("TotalWithoutDiscount: " + totalWithoutDiscount);
		
		double discount = DiscountPricing.calculateDiscount(shoppingList);
		
		double finalBill = totalWithoutDiscount - discount;
		System.out.println("TotalWithDiscount: "+ finalBill);
		
		
	}
	
	public static void main(String[] args) {
		ShoppingBasket sb = new ShoppingBasket();
		
		Product.inventory.stream().forEach(sb::addToShoppingList);
		sb.addToShoppingList(Product.inventory.get(1));
		sb.addToShoppingList(Product.inventory.get(2));
		sb.addToShoppingList(Product.inventory.get(3));
		sb.addToShoppingList(Product.inventory.get(3));
		sb.addToShoppingList(Product.inventory.get(3));
		sb.addToShoppingList(Product.inventory.get(3));
		
		sb.priceBasket();
	}
	
}
