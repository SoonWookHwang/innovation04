package sparta.week4homework.dto;

import lombok.*;
import sparta.week4homework.entitiy.Comment;
import sparta.week4homework.entitiy.Post;
import sparta.week4homework.entitiy.User;




@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentRequestDto {

    private Long id;
    private String comment;
    private User user;
    private Post posts;
    /* Dto -> Entity */
    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(id)
                .comment(comment)
                .user(user)
                .posts(posts)
                .build();

        return comments;
    }
}

