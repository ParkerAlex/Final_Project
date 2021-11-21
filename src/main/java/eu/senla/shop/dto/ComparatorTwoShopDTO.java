package eu.senla.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComparatorTwoShopDTO {

    private String productName;
    private String firstShopName;
    private String secondShopName;
    private Map<Integer, LocalDate> firstShopPrices = new HashMap<>();
    private Map<Integer, LocalDate> secondShopPrices = new HashMap<>();

    @Override
    public String toString() {
        return "PriceComparatorDTO{" +
                "productName='" + productName + '\'' +
                ", firstShopName='" + firstShopName + '\'' +
                ", firstShopPrices=" + firstShopPrices + '\'' +
                ", secondShopName='" + secondShopName + '\'' +
                ", secondShopPrices=" + secondShopPrices +
                '}';
    }
}
