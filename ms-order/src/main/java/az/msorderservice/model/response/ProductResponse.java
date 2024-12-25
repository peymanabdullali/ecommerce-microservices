package az.msorderservice.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private Integer quantity;
    private String description;
    private Double price;
}
