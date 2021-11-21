package eu.senla.shop.api.services;

import eu.senla.shop.api.repository.IShopRepository;
import eu.senla.shop.dto.ShopDTO;

public interface IShopService extends IGenericService<ShopDTO> {

    ShopDTO findByName(String name);

    void deleteByName(String shopName);

    void setShopRepository(IShopRepository shopRepository);
}
