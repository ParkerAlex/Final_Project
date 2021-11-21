package eu.senla.shop.api.comparator;

import eu.senla.shop.dto.ComparatorTwoShopDTO;
import eu.senla.shop.dto.PriceDTO;

import java.util.List;

public interface IPriceShopComparator {

    ComparatorTwoShopDTO getPriceComparator(
            String productName, String firstNameShop, String secondNameShop,
            List<PriceDTO> pricesFirstShop, List<PriceDTO> pricesSecondShop);
}
