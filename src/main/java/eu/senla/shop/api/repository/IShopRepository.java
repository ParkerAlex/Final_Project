package eu.senla.shop.api.repository;

import eu.senla.shop.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShopRepository extends JpaRepository<Shop, Long> {

    Shop findByName(String name);

    void deleteByName(String name);
}
    