package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Locale.filter;

@RestController
public class ShopController {

    private final StorageService storageService;
    private final BasketService basketService;

    public ShopController(StorageService storageService, BasketService basketService) {
        this.storageService = storageService;
        this.basketService = basketService;
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageService.returnProducts();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return storageService.returnArticles();
    }

    @GetMapping("/search")
    public List<SearchResult> findPattern(@RequestParam String pattern) {
        return this.storageService.getAllSearchable().stream()
                .filter(searchable -> searchable.getSearchTerm().toLowerCase().contains(pattern.toLowerCase()))
                .map(SearchResult::fromSearchable).collect(Collectors.toList());
    }

    @GetMapping("/basket/{id}")
    public String addProduct(@PathVariable("id") UUID id) {
        basketService.addProductById(id);
        return "Продукт успешно добавлен";
    }

    @GetMapping("/basket")
    public UserBasket getUserBasket() {
        return basketService.getUserBasket();
    }

}
