package eu.senla.shop.api.repository;

import eu.senla.shop.model.Intermediate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIntermediateRepository extends JpaRepository<Intermediate, Long> {
}
