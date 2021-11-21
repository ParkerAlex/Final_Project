package eu.senla.shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PriceDTO {

    private Long id;

    @Min(value = 0)
    @NotEmpty
    private Integer price;
    @NotEmpty
    private LocalDate checkIn;
}
