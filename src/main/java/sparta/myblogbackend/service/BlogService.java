package sparta.myblogbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.myblogbackend.domain.Blog;
import sparta.myblogbackend.repository.BlogRepository;
import sparta.myblogbackend.dto.BlogRequestDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    @Transactional
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @Transactional
    public Blog saveBlog(Blog blog){
        return blogRepository.save(blog);
    }

    @Transactional
    public Long update(Long id, BlogRequestDto requestDto) {
        Blog blog1 = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        blog1.update(requestDto);
        return blog1.getId();
    }
    @Transactional
    public boolean checkPassword(Long id, BlogRequestDto RequestDto) {
        Blog blog2 = blogRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("해당 아이디가 존재하지 않습니다.")
        );
        return RequestDto.getPassword().equals(blog2.getPassword());
    }
}
