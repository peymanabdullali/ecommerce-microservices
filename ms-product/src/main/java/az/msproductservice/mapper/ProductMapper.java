package az.msproductservice.mapper;

import az.msproductservice.dao.entity.ProductEntity;
import az.msproductservice.model.request.ProductRequest;
import az.msproductservice.model.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "request.categoryId", target = "category.id")
    ProductEntity mapToEntity(ProductRequest request);

    ProductResponse mapToResponse(ProductEntity entity);
}
