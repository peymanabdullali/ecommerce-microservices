package az.msorderservice.model.request;


import az.msorderservice.enums.PaymentType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

import static az.msorderservice.constants.Constants.PRODUCT_ID_AND_QUANTITY_IS_REQUIRED;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    //key - productId, value - quantity
    @NotNull(message = PRODUCT_ID_AND_QUANTITY_IS_REQUIRED)
    private Map<Long, Integer> products;
    private PaymentType paymentType;
}
