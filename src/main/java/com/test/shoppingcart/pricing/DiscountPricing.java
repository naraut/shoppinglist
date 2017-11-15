package com.test.shoppingcart.pricing;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.test.shoppingcart.Product;
import com.test.shoppingcart.Product.Offer;

// Calculates discounts
public class DiscountPricing {
	
	public static double calculateDiscount(List<Product> shoppingList) {
		
		Map<String, List<Product>> bogofMap = getProductsByOffer(shoppingList, (p1) -> (p1.getOffer().equals(Offer.BOGOF)));
		Map<String, List<Product>> threeForTwoMap = getProductsByOffer(shoppingList, (p1) -> (p1.getOffer().equals(Offer.ThreeForTwo)));
		
		Double discount = bogofMap.values().stream().map((list) -> new BOGOF<>().apply(list))
									.collect(summingDouble(d -> d));
		
		discount += threeForTwoMap.values().stream().map((list) -> new ThreeForTwo<>().apply(list))
									.collect(summingDouble(d -> d));
		
		
		return discount;
	}
	
	// More than 1 product can have the same offer.
	private static Map<String, List<Product>> getProductsByOffer(List<Product> shoppingList, Predicate<Product> offerPredicate) {
		return shoppingList.stream()
				.filter(offerPredicate)				  
				.collect(groupingBy(Product::getName));	
	}
	
}
