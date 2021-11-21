package eu.senla.shop.api.services;

import java.util.List;

public interface IGenericService<Y> {

    Y save(Y DTO);

    void delete(Y DTO);

    void deleteById(Long id);

    void deleteAll();

    Y findById(Long id);

    List<Y> findAll();
}
