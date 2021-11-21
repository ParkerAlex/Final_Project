package eu.senla.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prices")
public class Price extends AEntity {

    @Column(name = "cost", nullable = false)
    private Integer price;

    @Column(name = "check_in", columnDefinition = "DATE")
    private LocalDate checkIn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intermediates_id", nullable = false)
    private Intermediate intermediate;
}

