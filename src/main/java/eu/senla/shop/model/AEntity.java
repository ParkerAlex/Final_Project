package eu.senla.shop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class AEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;
}
