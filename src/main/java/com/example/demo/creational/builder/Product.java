package com.example.demo.creational.builder;

import lombok.Data;

@Data
public class Product {

	private String name;
    private Long price;
    
    public static class BuilderProduct {
    	private String name;
        private Long price;

    	public BuilderProduct setName(String name) {
    		this.name = name;
    		return this;
    	}

    	public BuilderProduct setPrice(Long price) {
    		this.price = price;
    		return this;
    	}    
    	
    	public Product build() {
        	return new Product(this);
        }
    }

    private Product (BuilderProduct builderProduct) {
        this.name = builderProduct.name;
        this.price = builderProduct.price;    
    }
    
    
}

	
	
