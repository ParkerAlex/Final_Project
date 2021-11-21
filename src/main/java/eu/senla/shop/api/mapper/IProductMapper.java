package eu.senla.shop.api.mapper;

import eu.senla.shop.dto.ProductDTO;
import eu.senla.shop.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    ProductDTO toDTO(Product product);

    Product toProduct(ProductDTO productDTO);
}
