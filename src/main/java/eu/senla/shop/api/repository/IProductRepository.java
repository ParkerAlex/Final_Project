package eu.senla.shop.api.repository;

import eu.senla.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

    void deleteByName(String name);

    List<Product> findAllByCategoryId(Long id);

    List<Product> findAllByCategoryName(String name);
}
