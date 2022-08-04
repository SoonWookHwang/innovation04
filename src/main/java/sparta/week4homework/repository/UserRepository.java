package sparta.week4homework.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import sparta.week4homework.entitiy.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    //SELECT * FROM user WHERE username =1?;
    User findByUsername(String username);

}