package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private double basicPrice;
    private int discount;


    public DiscountedProduct(String name, double basicPrice, int discount, UUID id) {
        super(name, id);
        this.basicPrice = basicPrice;
        if (basicPrice <= 0) {
            throw new IllegalArgumentException("Базовая цена задана некорректно!");
        }
        this.discount = discount;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка задана некорректно!");
        }
    }

    @Override
    public double getPrice() {
        double price = 0;
        if (discount > 0 && discount <= 100) {
            price = basicPrice * (1 - ((double) discount / 100));
        }
        return price;
    }

    @Override
    public String toString() {
        return getName() + " : " + basicPrice + " " + "(" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }


}
