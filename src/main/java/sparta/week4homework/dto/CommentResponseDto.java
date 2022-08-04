package sparta.week4homework.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sparta.week4homework.entitiy.Comment;
import sparta.week4homework.entitiy.Post;




@RequiredArgsConstructor
@Getter
public class CommentResponseDto {

    private Long id;
    private String comment;
    private String username;
    private Long userId;
    private Long postsId;
    /* Entity -> Dto*/

//    private final Long id;
//    private final String title;
//    private final String writer;
//    private final String content;
//    private final Long userId;
//    private final List<PostResponseDto> comments;
    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.username = comment.getUser().getUsername();
        this.userId = comment.getUser().getId();
        this.postsId = comment.getPosts().getId();
    }
}

