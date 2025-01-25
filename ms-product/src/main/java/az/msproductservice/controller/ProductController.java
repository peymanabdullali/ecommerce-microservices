package az.msproductservice.controller;

import az.msproductservice.model.request.ProductRequest;
import az.msproductservice.model.response.ProductResponse;
import az.msproductservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("v1/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(CREATED)
//    @CheckPermission("ROLE_ADMIN")
    public void createProduct(@Valid @RequestBody ProductRequest productRequest,
                              @RequestHeader(name = "Role") String role) {
        System.out.println(role);
        productService.createProduct(productRequest);
    }

    @GetMapping("{id}")
    public ProductResponse getProductById(@PathVariable Long id,
                                          @RequestHeader(name = "Role",required = false) String role,
                                          @RequestHeader(name = "UserId",required = false) String userid) {
        System.out.println(role);
        System.out.println(userid);
        return productService.getProductById(id);
    }

    @PostMapping("update-quantity")
    void updateQuantity(@RequestBody Map<Long, Integer> products) {
        productService.updateQuantity(products);
    }

    @GetMapping("get-products")
    public List<ProductResponse> getProductsByIds(@RequestParam List<Long> ids) {
        return productService.getProductsById(ids);
    }


}
