package sparta.week4homework.dto;

import lombok.*;
import sparta.week4homework.entitiy.Post;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PostResponseDto {
    private final Long id;
    private final String title;
    private final String writer;
    private final String content;
    private final Long userId;
    private final List<PostResponseDto> comments;

    /* Entity -> Dto*/
    public PostResponseDto(Post posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.writer = posts.getWriter();
        this.content = posts.getContent();
        this.userId = posts.getUser().getId();
        this.comments = posts.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
