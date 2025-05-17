package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StorageService {

    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService(Map<UUID, Product> products, Map<UUID, Article> articles) {
        this.products = products;
        this.articles = articles;
        createTestData();
    }

    public Collection<Product> returnProducts() {
        return products.values();
    }

    public Collection<Article> returnArticles() {
        return articles.values();
    }

    private void createTestData() {
        Product cucumber = new SimpleProduct("огурец", 200, UUID.randomUUID());
        this.products.put(cucumber.getId(), cucumber);
        Product tomato = new SimpleProduct("помидор", 110, UUID.randomUUID());
        this.products.put(tomato.getId(), tomato);
        Product banana = new SimpleProduct("банан", 150, UUID.randomUUID());
        this.products.put(banana.getId(), banana);
        Product chicken = new SimpleProduct("курица", 210, UUID.randomUUID());
        this.products.put(chicken.getId(), chicken);
        Product pig = new SimpleProduct("свинина", 300, UUID.randomUUID());
        this.products.put(pig.getId(), pig);
        Product milk = new SimpleProduct("молоко", 100, UUID.randomUUID());
        this.products.put(milk.getId(), milk);
        Product beer = new SimpleProduct("пиво", 115, UUID.randomUUID());
        this.products.put(beer.getId(), beer);
        Product oatmeal = new SimpleProduct("овсянка", 80, UUID.randomUUID());
        this.products.put(oatmeal.getId(), oatmeal);
        Product apple = new SimpleProduct("яблоко", 155, UUID.randomUUID());
        this.products.put(apple.getId(), apple);
        Product orange = new SimpleProduct("апельсин", 180, UUID.randomUUID());
        this.products.put(orange.getId(), orange);

        SimpleProduct fish = new SimpleProduct("рыба", 200, UUID.randomUUID());
        this.products.put(fish.getId(), fish);
        DiscountedProduct eggs = new DiscountedProduct("яйца", 1000, 50, UUID.randomUUID());
        this.products.put(eggs.getId(), eggs);
        FixPriceProduct tea = new FixPriceProduct("чай", UUID.randomUUID());
        this.products.put(tea.getId(), tea);
        Article article1 = new Article("Безопасность мореплавания.", "Средства навигационного оборудования - самая важная отрасль.", UUID.randomUUID());
        this.articles.put(article1.getId(), article1);
        Article article2 = new Article("Маяки России.", "Первый этап проекта — электронная энциклопедия российских исторических маяков.", UUID.randomUUID());
        this.articles.put(article2.getId(), article2);
        Article article3 = new Article("Маяки народов России.", "Второй этап проекта — сбор и оцифровка фотоархивов.", UUID.randomUUID());
        this.articles.put(article3.getId(), article3);
    }

    @GetMapping("/searchable")
    public Collection<Searchable> getAllSearchable() {
        return Stream.concat(products.values().stream(),articles.values().stream()).collect(Collectors.toList());
    }

}
