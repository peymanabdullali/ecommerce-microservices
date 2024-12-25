package az.msorderservice.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.io.InputStream;
@Component
public class FeignErrorMapper {

    public <T> T map(InputStream source, Class<T> target) {
        try {
            return  new ObjectMapper().readValue(source,target);

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
