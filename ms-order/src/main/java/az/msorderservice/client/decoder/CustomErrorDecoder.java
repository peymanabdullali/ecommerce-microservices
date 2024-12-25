package az.msorderservice.client.decoder;

import az.msorderservice.exception.CustomFeignClientException;
import az.msorderservice.mapper.FeignErrorMapper;
import com.fasterxml.jackson.databind.JsonNode;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;

import java.io.InputStream;

import static az.msorderservice.enums.Messages.*;

@RequiredArgsConstructor
public class CustomErrorDecoder implements ErrorDecoder {
    private final FeignErrorMapper errorMapper;

    @Override
    public Exception decode(String methodKey, Response response) {
        int statusCode = response.status();
        String message = CLIENT_ERROR.getMessage();
        JsonNode node;
        try (InputStream inputStream = response.body().asInputStream()) {
            node = errorMapper.map(inputStream, JsonNode.class);
        } catch (Exception e) {
            throw new CustomFeignClientException(statusCode, CLIENT_ERROR.getMessage());
        }
        if (node.has("message"))
            message = node.get("message").asText();
        return new CustomFeignClientException(statusCode, message);

    }


}