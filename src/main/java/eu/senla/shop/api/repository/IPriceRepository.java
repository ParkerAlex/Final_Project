package eu.senla.shop.api.repository;

import eu.senla.shop.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPriceRepository extends JpaRepository<Price, Long> {

    List<Price> getAllByIntermediateProductIdAndIntermediateShopId(Long productId, Long shopId);

    List<Price> findAllByIntermediateProductNameAndIntermediateShopName(String productName, String shopName);
}