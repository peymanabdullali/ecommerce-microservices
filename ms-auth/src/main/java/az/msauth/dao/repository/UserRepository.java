package az.msauth.dao.repository;



import az.msauth.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "select * from users where email=:email limit 1",nativeQuery = true)
    Optional<UserEntity> findByEmail(@Param("email")String email);
}
