package eu.senla.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "intermediates")
public class Intermediate extends AEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shops_id", nullable = false)
    private Shop shop;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "products_id", nullable = false)
    private Product product;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "intermediate")
    private List<Price> prices = new ArrayList<>();
}
