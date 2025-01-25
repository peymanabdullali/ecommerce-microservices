package az.msauth.service.auth;

import az.msauth.dao.entity.UserEntity;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
public class CustomUserDetails implements UserDetails {
    private final Long userId;
    private final String username;
    private final String password;
    private final List<GrantedAuthority> grantedAuthorities;
   public CustomUserDetails(UserEntity entity) {
        this.username = entity.getEmail();
        this.password = entity.getPassword();
        this.userId = entity.getId();
        this.grantedAuthorities =
                Collections.singletonList(new SimpleGrantedAuthority(entity.getRole().name()));
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
