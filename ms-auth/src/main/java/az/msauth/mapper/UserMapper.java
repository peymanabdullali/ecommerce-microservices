package az.msauth.mapper;

import az.msauth.dao.entity.UserEntity;
import az.msauth.model.request.UserRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import static az.msauth.dao.enums.Role.ROLE_USER;

@Mapper(componentModel = "spring"
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface UserMapper {
    UserEntity mapToEntity(UserRequest userRequest);

    @AfterMapping
    default void setDefaultRole(@MappingTarget UserEntity entity) {
        if (entity.getRole() == null) {
            entity.setRole(ROLE_USER);
        }
    }
}
