package az.msorderservice.model;

import az.msorderservice.model.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    private ProductResponse product;
    private Integer quantity;
}
