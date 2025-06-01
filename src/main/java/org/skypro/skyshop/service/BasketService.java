package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.exeptions.NoSuchProductException;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final StorageService storageService;
    private final ProductBasket productBasket;

    public BasketService(StorageService storageService, ProductBasket productBasket) {
        this.storageService = storageService;
        this.productBasket = productBasket;
    }

    public void addProductById(UUID id) {
        Product product =  storageService.getProductById(id);
        productBasket.addProduct(id);
    }

    public UserBasket getUserBasket() {
        Map<UUID, Integer> basketMap = productBasket.getBasket();
        List<BasketItem> basketItemList = basketMap.entrySet().stream()
                .map(map -> new BasketItem(storageService.getProductById(map.getKey()), map.getValue()))
                .collect(Collectors.toCollection(() -> new ArrayList<BasketItem>()));
        double total = basketItemList.stream()
                .mapToDouble(price -> price.getQuantity() * price.getProduct().getPrice())
                .sum();
        return new UserBasket(basketItemList, total);
    }
}


