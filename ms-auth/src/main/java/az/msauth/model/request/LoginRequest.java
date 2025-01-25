package az.msauth.model.request;

import lombok.Data;

@Data
public class LoginRequest {
    String email;
    String password;
}
