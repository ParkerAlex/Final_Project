package eu.senla.shop.api.mapper;

import eu.senla.shop.dto.IntermediateDTO;
import eu.senla.shop.model.Intermediate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IIntermediateMapper {

    IIntermediateMapper INSTANCE = Mappers.getMapper(IIntermediateMapper.class);

    IntermediateDTO toDTO(Intermediate intermediate);

    Intermediate toIntermediate(IntermediateDTO intermediateDTO);
}
