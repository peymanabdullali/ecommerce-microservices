package az.msauth.controller;

import az.msauth.model.request.LoginRequest;
import az.msauth.model.request.UserRequest;
import az.msauth.model.response.LoginResponse;
import az.msauth.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping("v1/api/auth")
@RequiredArgsConstructor
public class LoginController {
    private final AuthService service;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return service.login(request);
    }

    @PostMapping("/register")
    @ResponseStatus(CREATED)
    public void register(@RequestBody UserRequest request) {
        service.register(request);
    }
}
