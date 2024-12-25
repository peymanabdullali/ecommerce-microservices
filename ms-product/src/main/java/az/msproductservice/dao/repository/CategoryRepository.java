package az.msproductservice.dao.repository;

import az.msproductservice.dao.entity.CategoryEntity;
import az.msproductservice.dao.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
