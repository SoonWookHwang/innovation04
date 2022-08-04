package sparta.week4homework.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sparta.week4homework.entitiy.User;
import sparta.week4homework.entitiy.UserRoleEnum;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private final User user;  //콤포지션

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getPassword() {

        return user.getPassword();
    }

    @Override
    public String getUsername() {

        return user.getUsername();
    }

    @Override //계정이 만료되지 않았는지 리턴 true - 만료안됌됌
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override //계정이 잠기지 않았는지 리턴 true - 잠기지 않음
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override// 비밀번호가 만료되지 않았는지 리턴 true - 만료안됨
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override // 계정이 활성화(사용가능)인지 리턴 true - 활성화
    public boolean isEnabled() {
        return true;
    }

    @Override  // 계정의 권한을 리턴
    public Collection<? extends GrantedAuthority> getAuthorities() {
        UserRoleEnum role = user.getRole();
        String authority = role.getAuthority();

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        return authorities;

    }
}