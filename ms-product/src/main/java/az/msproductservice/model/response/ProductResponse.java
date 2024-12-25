package az.msproductservice.model.response;

import az.msproductservice.dao.enums.EColor;
import lombok.Builder;
import lombok.Data;


import java.util.Map;
@Data
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private Integer quantity;
    private String description;
    private Double price;
}
