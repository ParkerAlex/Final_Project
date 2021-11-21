package eu.senla.shop.api.diagram;

import eu.senla.shop.dto.PriceDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IDiagram {

    Map<Integer, LocalDate> getDiagram(List<PriceDTO> priceList);
}
