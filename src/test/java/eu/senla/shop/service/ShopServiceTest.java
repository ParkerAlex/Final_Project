package eu.senla.shop.service;

import eu.senla.shop.api.repository.IShopRepository;
import eu.senla.shop.api.services.IShopService;
import eu.senla.shop.dto.ShopDTO;
import eu.senla.shop.model.Shop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ShopServiceTest {

    @Mock
    private IShopRepository shopRepository;

    @Autowired
    private IShopService shopService;
    private Shop shop;
    private ShopDTO shopDTO;
    private List<ShopDTO> shopDTOS;
    private List<Shop> shops;

    @BeforeEach
    void setUp() {
        shopService.setShopRepository(shopRepository);
        shop = new Shop(1L, "test");
        shopDTO = new ShopDTO(1L, "test");
        shopDTOS = new ArrayList<>();
        shopDTOS.add(shopDTO);
        shops = new ArrayList<>();
        shops.add(shop);
    }

    @Test
    void ShouldMethodDeleteById() {
        shopService.deleteById(1L);
        verify(shopRepository).deleteById(anyLong());
    }

    @Test
    void ShouldCallMethodDeleteAll() {
        shopService.deleteAll();
        verify(shopRepository).deleteAll();
    }

    @Test
    void ShouldDtoWithId() {
        when(shopRepository.save(ArgumentMatchers.any(Shop.class))).thenReturn(shop);
        ShopDTO result = shopService.save(shopDTO);
        assertEquals(result.getId(), 1);
        verify(shopRepository).save(shop);
    }

    @Test
    void ShouldMethodDeleteByEntity() {
        shopService.delete(shopDTO);
        verify(shopRepository).delete(ArgumentMatchers.any(Shop.class));
    }
}