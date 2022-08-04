package sparta.week4homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import sparta.week4homework.dto.CommentRequestDto;
import sparta.week4homework.dto.PostRequestDto;
import sparta.week4homework.entitiy.Comment;
import sparta.week4homework.security.UserDetailsImpl;
import sparta.week4homework.service.CommentService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

//    @Autowired
//    public CommentController(CommentService commentService) {
//        this.commentService = commentService;
//    }


    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        Long userId = userDetails.getUser().getId();

        Comment comment = commentService.createComment(commentRequestDto, userId);

        return comment;
    }

    @GetMapping("/api/comments") // 해당 content의 모든 댓글을 불러오기
    public List<Comment> getComments(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 로그인 되어 있는 회원 테이블의 ID
        Long Id = userDetails.getUser().getId();
        List<Comment> comments = new ArrayList<>()
                comments.add(commentRequestDto);

        return commentService.getComments();
    }


    @PutMapping("/api/comments/{username}")
    public String updateComment(@PathVariable String username, @RequestBody CommentRequestDto commentRequestDto) {
        Comment comment = commentService.updateComment(username, commentRequestDto);
        return "댓글 수정완료";
    }

    @DeleteMapping("/api/comments/{id}")
    public String deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return "댓글 삭제완료";
    }

}
