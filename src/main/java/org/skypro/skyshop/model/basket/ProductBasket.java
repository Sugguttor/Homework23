package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@SessionScope
@Component
public class ProductBasket {
    private final Map<UUID, Integer> products;

    public ProductBasket(Map<UUID, Integer> products) {
        this.products = products;
    }

    public void addProduct(UUID id) {
        products.put(id, products.getOrDefault(id, 0) + 1);
    }

    public Map<UUID, Integer> getBasket() {
        return Collections.unmodifiableMap(this.products);
    }

}

