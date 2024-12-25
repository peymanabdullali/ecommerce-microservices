package az.msproductservice.service.impl;

import az.msproductservice.dao.entity.ProductEntity;
import az.msproductservice.dao.repository.ProductRepository;
import az.msproductservice.exception.InsufficientQuantityException;
import az.msproductservice.exception.NotFoundException;
import az.msproductservice.mapper.ProductMapper;
import az.msproductservice.model.request.ProductRequest;
import az.msproductservice.model.response.AmountResponse;
import az.msproductservice.model.response.ProductResponse;
import az.msproductservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static az.msproductservice.model.enums.Messages.*;
import static java.lang.String.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void createProduct(ProductRequest request) {
        productRepository.save(productMapper.mapToEntity(request));
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productMapper.mapToResponse(productRepository.findById(id).
                orElseThrow(() -> new NotFoundException(format(PRODUCT_NOT_FOUND.getMessage(), id))));
    }

    @Override
    public void updateQuantity(Map<Long, Integer> products) {
        //key -> productId, value -> quantity
        List<ProductEntity> productList = productRepository.findAllById(products.keySet());
        if (productList.isEmpty()) {
            throw new NotFoundException(format(PRODUCT_NOT_FOUND.getMessage(), products.keySet()));
        }
        productList.stream().filter(i -> {
            if (i.getQuantity() < products.get(i.getId()))
                throw new InsufficientQuantityException(
                        format(INSUFFICIENT_QUANTITY.getMessage(),
                                i.getId(), i.getQuantity(), products.get(i.getId()))
                );
            else return true;
        }).forEach(product -> product.setQuantity(
                product.getQuantity() - products.get(product.getId())
        ));
        productRepository.saveAll(productList);
//        return new AmountResponse(
//                productList.stream().mapToDouble(i -> i.getPrice() * products.get(i.getId())).sum()
//        );

    }

    @Override
    public List<ProductResponse> getProductsById(List<Long> ids) {
        return productRepository.findAllById(ids).stream().
                map(productMapper::mapToResponse).toList();
    }
}
