package az.msauth.service.auth;

import az.msauth.dao.repository.UserRepository;
import az.msauth.mapper.UserMapper;
import az.msauth.model.request.LoginRequest;
import az.msauth.model.request.UserRequest;
import az.msauth.model.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final UserDetailsService service;
    private final UserMapper userMapper;
    private final UserRepository repository;

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        if (authenticate.isAuthenticated()) {
            System.out.println("authenticate");
        }
        CustomUserDetails user = (CustomUserDetails) service.loadUserByUsername(loginRequest.getEmail());
        var jwtToken = jwtService.generateToken(user);
        return LoginResponse.builder()
                .token(jwtToken)
                .build();
    }

    public void register(UserRequest request) {
        repository.save(userMapper.mapToEntity(request));
    }

}