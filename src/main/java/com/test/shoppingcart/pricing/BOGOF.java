package com.test.shoppingcart.pricing;

import java.util.List;
import java.util.function.Function;

import com.test.shoppingcart.Product;

public class BOGOF<P, D> implements Function<List<Product>, Double> {

	@Override
	public Double apply(List<Product> listOfProducts) {
		double discount = 0d;
		if(listOfProducts.size() >= 2) {
			int doubles = listOfProducts.size()/2;
			discount = listOfProducts.get(0).getPrice() * doubles;
		}
		return discount;
	}

}
