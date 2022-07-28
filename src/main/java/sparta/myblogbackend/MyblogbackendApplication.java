package sparta.myblogbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sparta.myblogbackend.domain.Blog;
import sparta.myblogbackend.repository.BlogRepository;
import sparta.myblogbackend.dto.BlogRequestDto;
import sparta.myblogbackend.service.BlogService;
import java.util.List;

@SpringBootApplication
public class MyblogbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyblogbackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BlogRepository blogRepository, BlogService blogService) {
		return (args) -> {
			blogRepository.save(new Blog("hello blog", "hello","황순욱","1234"));

			System.out.println("데이터 인쇄");
			List<Blog> blogList = blogRepository.findAll();
			for (int i=0; i<blogList.size(); i++) {
				Blog blog = blogList.get(i);
				System.out.println(blog.getId());
				System.out.println(blog.getTitle());
				System.out.println(blog.getContent());
				System.out.println(blog.getAuthor());
				System.out.println(blog.getPassword());
			}

			BlogRequestDto requestDto = new BlogRequestDto("웹개발의 봄, Spring", "임민영","황순욱","4567");
			blogService.update(1L, requestDto);
			blogList = blogRepository.findAll();
			for (int i=0; i<blogList.size(); i++) {
				Blog blog = blogList.get(i);
				System.out.println(blog.getId());
				System.out.println(blog.getTitle());
				System.out.println(blog.getContent());
				System.out.println(blog.getAuthor());
				System.out.println(blog.getPassword());
			}
		};
	}
}


