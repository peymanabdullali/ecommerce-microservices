package az.msproductservice.service;

import az.msproductservice.model.request.ProductRequest;
import az.msproductservice.model.response.AmountResponse;
import az.msproductservice.model.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ProductService {
    void createProduct(ProductRequest request);

    ProductResponse getProductById(Long id);

    void updateQuantity(Map<Long, Integer> products);

    List<ProductResponse> getProductsById(List<Long> ids);
}
