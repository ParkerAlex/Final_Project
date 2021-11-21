package eu.senla.shop.util.comparator;

import eu.senla.shop.api.comparator.IPriceShopComparator;
import eu.senla.shop.api.diagram.IDiagram;
import eu.senla.shop.dto.ComparatorTwoShopDTO;
import eu.senla.shop.dto.PriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceShopComparator implements IPriceShopComparator {

    @Autowired
    private IDiagram diagram;

    public ComparatorTwoShopDTO getPriceComparator(
            String goodsName, String firstShopName, String secondShopName,
            List<PriceDTO> firstShopPrice, List<PriceDTO> secondShopPrice) {
        return ComparatorTwoShopDTO
                .builder()
                .productName(goodsName)
                .firstShopName(firstShopName)
                .secondShopName(secondShopName)
                .firstShopPrices(diagram.getDiagram(firstShopPrice))
                .secondShopPrices(diagram.getDiagram(secondShopPrice))
                .build();
    }
}
