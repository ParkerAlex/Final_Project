package eu.senla.shop.api.services;

import eu.senla.shop.dto.CategoryDTO;

public interface ICategoryService extends IGenericService<CategoryDTO> {

    CategoryDTO findByName(String name);

    void deleteByName(String name);
}
