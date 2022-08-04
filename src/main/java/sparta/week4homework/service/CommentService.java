package sparta.week4homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.week4homework.dto.CommentRequestDto;
import sparta.week4homework.dto.CommentResponseDto;
import sparta.week4homework.dto.PostRequestDto;
import sparta.week4homework.entitiy.Comment;
import sparta.week4homework.entitiy.Post;
import sparta.week4homework.entitiy.User;
import sparta.week4homework.repository.CommentRepository;
import sparta.week4homework.repository.PostRepository;
import sparta.week4homework.repository.UserRepository;


import java.util.List;
import java.util.stream.Collectors;




@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    /* CREATE */
    @Transactional
    public Long create(Long id, String username, CommentRequestDto dto) {
        User user = userRepository.findByUsername(username);
        Post posts = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다. " + id));

        dto.setUser(user);
        dto.setPosts(posts);

        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return comment.getId();
    }

    /* READ */
    @Transactional(readOnly = true)
    public List<CommentResponseDto> findAll(Long id) {
        Post posts = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));
        List<Comment> comments = posts.getComments();
        return comments.stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }

    /* UPDATE */
    @Transactional
    public void update(Long id, CommentRequestDto dto) {
        Comment comment = commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. " + id));

        comment.update(dto.getComment());
    }

    /* DELETE */
    @Transactional
    public void delete(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id=" + id));

        commentRepository.delete(comment);
    }
}