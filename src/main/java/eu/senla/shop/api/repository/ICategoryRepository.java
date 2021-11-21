package eu.senla.shop.api.repository;

import eu.senla.shop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

    void deleteByName(String name);
}
