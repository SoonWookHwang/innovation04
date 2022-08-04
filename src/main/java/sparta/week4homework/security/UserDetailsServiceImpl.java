package sparta.week4homework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sparta.week4homework.entitiy.User;
import sparta.week4homework.repository.UserRepository;

@Service //bean 등록
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //스프링이 로그인 요청을 가로챌 때, username,password 변수 2개를 가로채는데
    //password 부분 처리는 알아서 함
    //username이 DB에 있는지만 확인해주면 됌
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. " + username));

        return new UserDetailsImpl(user); //시큐리티 세션에 유저 정보가 저장이 됨 //UserDetails타입으로
    }
}