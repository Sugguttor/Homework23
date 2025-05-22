package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {

    private final List<BasketItem> basketItems;
    private final double total;

    public UserBasket(List<BasketItem> basketItems, double total) {
        this.basketItems = basketItems;
        this.total = calculateTotal(basketItems);
    }

    private double calculateTotal(List<BasketItem> basketItems) {
        return basketItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }


}
