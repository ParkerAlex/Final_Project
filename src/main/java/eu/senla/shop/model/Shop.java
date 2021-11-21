package eu.senla.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shops")
public class Shop extends AEntity {

    @Column(name = "name", length = 30, nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
    private Set<Intermediate> intermediates = new HashSet<>();

    public Shop(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
