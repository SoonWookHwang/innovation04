package sparta.week4homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.week4homework.entitiy.Comment;
import sparta.week4homework.entitiy.Post;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> getCommentByPostsOrderById(Post posts);

}