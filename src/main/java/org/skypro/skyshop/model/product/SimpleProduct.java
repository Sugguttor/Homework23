package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    public double price;
    private final UUID id;

    public SimpleProduct(String name, int price, UUID id) {
        super(name, id);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена задана некорректно!");
        }
        this.price = price;
        this.id = id;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return getName() + " : " + price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }


}
