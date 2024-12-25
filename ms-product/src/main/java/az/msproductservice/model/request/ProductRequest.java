package az.msproductservice.model.request;

import az.msproductservice.constants.Constants;
import az.msproductservice.dao.enums.EColor;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


import java.util.Map;

import static az.msproductservice.constants.Constants.*;

@Data
@Builder
public class ProductRequest {
    @NotNull(message = NAME_IS_REQUIRED)
    private String name;

    @NotNull(message = QUANTITY_IS_REQUIRED)
    private Integer quantity;

    @NotNull(message = DESCRIPTION_IS_REQUIRED)
    private String description;

    @NotNull(message = PRICE_IS_REQUIRED)
    private Double price;
    Integer categoryId;
}
