package az.msorderservice.client;

import az.msorderservice.client.decoder.CustomErrorDecoder;
import az.msorderservice.model.response.AmountResponse;
import az.msorderservice.model.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(
        name = "ms-product-service",
        url = "http://localhost:8081/v1/api/products",
        configuration = CustomErrorDecoder.class )
public interface ProductClient {
    @PostMapping("update-quantity")
    void updateQuantity(@RequestBody Map<Long,Integer> products);
    @GetMapping("get-products")
    List<ProductResponse> getProductsByIds(@RequestParam List<Long> ids);
}
