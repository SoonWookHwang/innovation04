package sparta.myblogbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sparta.myblogbackend.domain.Blog;
import sparta.myblogbackend.repository.BlogRepository;
import sparta.myblogbackend.dto.BlogRequestDto;
import sparta.myblogbackend.service.BlogService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogController {

    private final BlogRepository blogRepository;
    private final BlogService blogService;

    @PostMapping("/blogs") // 게시글 작성 API
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        return blogService.saveBlog(blog);
    }

    @GetMapping("/blogs")  // 게시글 조회 API
    public List<Blog> getBlogs() {
        return blogService.getBlogs();
    }
    @PostMapping("/blogs/password/{id}") //비밀번호 확인 조회 API
    public boolean checkPassword(@PathVariable Long id,@RequestBody BlogRequestDto requestDto) {
        return blogService.checkPassword(id, requestDto);
    }

    @PutMapping("/blogs/{id}")  //게시글 수정 API
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        return blogService.update(id, requestDto);
    }
    @DeleteMapping("/blogs/{id}")  //게시글 삭제 API
    public Long deleteBlog(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return id;
    }
}
