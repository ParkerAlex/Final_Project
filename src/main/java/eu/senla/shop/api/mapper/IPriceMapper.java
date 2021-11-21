package eu.senla.shop.api.mapper;

import eu.senla.shop.dto.PriceDTO;
import eu.senla.shop.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IPriceMapper {

    IPriceMapper INSTANCE = Mappers.getMapper(IPriceMapper.class);

    PriceDTO toDTO(Price price);

    Price toPrice(PriceDTO PriceDTO);
}
