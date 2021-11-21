package eu.senla.shop.util.diagram;

import eu.senla.shop.api.diagram.IDiagram;
import eu.senla.shop.dto.PriceDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Diagram implements IDiagram {

    @Override
    public Map<Integer, LocalDate> getDiagram(List<PriceDTO> priceList) {
        return priceList.stream().collect(Collectors.toMap(PriceDTO::getPrice, PriceDTO::getCheckIn));
    }
}
