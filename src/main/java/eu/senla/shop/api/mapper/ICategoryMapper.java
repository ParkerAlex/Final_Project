package eu.senla.shop.api.mapper;

import eu.senla.shop.dto.CategoryDTO;
import eu.senla.shop.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {

    ICategoryMapper INSTANCE = Mappers.getMapper(ICategoryMapper.class);

    CategoryDTO toDTO(Category category);

    Category toCategory(CategoryDTO categoryDTO);
}
