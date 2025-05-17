package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Locale.filter;


@RestController
public class ShopController {

    private final StorageService storageService;


    public ShopController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return (Collection<Product>) storageService.returnProducts();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return (Collection<Article>) storageService.returnArticles();
    }

    @GetMapping("/search")
    public List<SearchResult> findPattern(@RequestParam String pattern) {
        return this.storageService.getAllSearchable().stream()
                .filter(searchable -> searchable.getSearchTerm().toLowerCase().contains(pattern.toLowerCase()))
                .map(SearchResult::fromSearchable).collect(Collectors.toList());
    }
}
