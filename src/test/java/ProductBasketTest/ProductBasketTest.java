package ProductBasketTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.service.StorageService;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProductBasketTest {
    @Mock
    private StorageService storageService;
    @Mock
    private ProductBasket productBasket;

    @Test
    public void givenNonexistentProduct_whenNotFind_thenThrowException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            productBasket.addProduct(null);
        });

        assertThat(exception).isNotNull()
                .hasMessageContaining("Not found");
    }


    @Test
    public void givenExistentProduct_whenNotFind_thenAddProduct() {
        UUID id = UUID.randomUUID();
        Product p1 = new SimpleProduct("Капуста", 30, id);
        BasketItem item = new BasketItem(p1, 1);
        List<BasketItem> basketItems = new ArrayList<>();
        basketItems.add(item);

        Mockito.when(productBasket.getBasket()).thenReturn(Map.of(id, 1));
        Mockito.verify(productBasket).addProduct(id);
    }

    @Test
    public void givenExistentProduct_whenBasketIsEmpty_thenGetUserBasket() {

        ProductBasket mockBasket = Mockito.mock(ProductBasket.class);
        Mockito.when(mockBasket.getBasket()).thenReturn((Map<UUID, Integer>) Collections.emptyList());
        Assertions.assertTrue(mockBasket.getBasket().isEmpty());

    }

    @Test
    public void givenExistentProduct_whenBasketIsNotEmpty_thenGetUserBasket() {

        ProductBasket mockBasket = Mockito.mock(ProductBasket.class);
        Mockito.when(mockBasket.getBasket()).thenReturn((new HashMap<>()));
        Assertions.assertTrue(mockBasket.getBasket().isEmpty());

    }



}
