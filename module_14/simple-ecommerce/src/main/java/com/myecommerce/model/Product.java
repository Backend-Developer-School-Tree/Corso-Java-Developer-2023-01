package com.myecommerce.model;

import java.util.Objects;

public class Product {

    private long id;
    private int stockAvailability;
    private double price;
    private String name;
    private String description;

    public Product(){}

    public Product(long id, int stockAvailability, double price, String name, String description) {
        this.id = id;
        this.stockAvailability = stockAvailability;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStockAvailability() {
        return stockAvailability;
    }

    public void setStockAvailability(int stockAvailability) {
        this.stockAvailability = stockAvailability;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) //se oggetto è se stesso allora è true
            return true;
        if(o == null || getClass() != o.getClass()) // getClass() equivale a this.getClass()
            return false;

        Product product = (Product) o; // Cast da Object a Product per poter usare il getId()
        return (id == product.getId());
    }

    @Override
    public String toString(){
        return "Product: " + name + " - " + description;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    public void decreaseStock(int quantity){
        stockAvailability -= quantity;
    }
}
