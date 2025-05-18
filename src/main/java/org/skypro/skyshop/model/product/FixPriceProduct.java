package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final double FIX_PRICE_PRODUCT = 100;

    public FixPriceProduct(String name, UUID id) {
        super(name, id);
    }

    @Override
    public double getPrice() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public String toString() {
        return getName() + " : " + "Фиксированная цена " + FIX_PRICE_PRODUCT;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
