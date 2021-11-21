package eu.senla.shop.api.services;

import eu.senla.shop.dto.ProductDTO;

import java.util.List;

public interface IProductService extends IGenericService<ProductDTO> {

    ProductDTO findByName(String name);

    void deleteByName(String shopName);

    void loadProductWithFile();

    List<ProductDTO> findAllByProductId(Long id);

    List<ProductDTO> findAllByProductName(String name);
}
