package eu.senla.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends AEntity {

    @Column(name = "name", length = 30, nullable = false, unique = true)
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "categories_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Intermediate> intermediates = new ArrayList<>();

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}
