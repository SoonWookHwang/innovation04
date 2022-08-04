package sparta.week4homework.dto;

import lombok.*;
import sparta.week4homework.entitiy.Post;
import sparta.week4homework.entitiy.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequestDto {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private User user;

    /* Dto -> Entity */
    public Post toEntity() {
        Post posts = Post.builder()
                .id(id)
                .title(title)
                .writer(writer)
                .content(content)
                .user(user)
                .build();

        return posts;
    }
}