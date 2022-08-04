package sparta.week4homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import sparta.week4homework.dto.CommentRequestDto;
import sparta.week4homework.dto.PostMyContentRequestDto;
import sparta.week4homework.dto.PostRequestDto;
import sparta.week4homework.entitiy.Comment;
import sparta.week4homework.entitiy.Post;
import sparta.week4homework.security.UserDetailsImpl;
import sparta.week4homework.service.CommentService;
import sparta.week4homework.service.PostService;

import java.util.List;


@RestController
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public PostController(PostService postService, CommentService commentService){
        this.postService = postService;
        this.commentService = commentService;
    }


    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getId();

        PostService postservice = this.createPost(postRequestDto,userId);

        return post;
    }

    @GetMapping("/api/posts")
    public List<Post> getPosts(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 로그인 되어 있는 회원 테이블의 ID
        Long Id = userDetails.getUser().getId();

        return postService.getPosts(Id);
    }
    @GetMapping("/api/posts/comments")
    public List<Comment> getCommnents(@RequestBody PostRequestDto postRequestDto){
        Object commentRequestDto = null;
        commentRequestDto.getPostID();
        return PostService.getComments();
    }

    @GetMapping("/api/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPost();
    }

    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostMyContentRequestDto postMyContentRequestDto) {
        Post post = postService.updatePost(id,postMyContentRequestDto);
        return post.getId();
    }

    @DeleteMapping("/api/posts/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "글이 삭제되었습니다";
    }


}
