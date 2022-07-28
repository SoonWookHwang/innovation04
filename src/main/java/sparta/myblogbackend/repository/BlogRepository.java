package sparta.myblogbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.myblogbackend.domain.Blog;

public interface BlogRepository extends JpaRepository<Blog,Long> {
}
