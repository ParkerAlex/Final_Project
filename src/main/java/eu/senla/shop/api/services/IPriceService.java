package eu.senla.shop.api.services;

import eu.senla.shop.dto.ComparatorTwoShopDTO;
import eu.senla.shop.dto.PriceDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IPriceService extends IGenericService<PriceDTO> {

    ComparatorTwoShopDTO comparatorTwoShops(
            String productName, String firstShopName, String secondShopName);

    Map<Integer, LocalDate> getDiagram(Long productId, Long shopId);

    List<PriceDTO> getAllProductIdAndShopId(Long productId, Long shopId);

    List<PriceDTO> findAllByShopNameAndProductName(String productName, String shopName);
}
