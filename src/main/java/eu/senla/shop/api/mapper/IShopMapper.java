package eu.senla.shop.api.mapper;

import eu.senla.shop.dto.ShopDTO;
import eu.senla.shop.model.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IShopMapper {

    IShopMapper INSTANCE = Mappers.getMapper(IShopMapper.class);

    ShopDTO toDTO(Shop shop);

    Shop toShop(ShopDTO ShopDTO);
}
