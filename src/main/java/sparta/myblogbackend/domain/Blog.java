package sparta.myblogbackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sparta.myblogbackend.dto.BlogRequestDto;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Getter
@NoArgsConstructor
@Entity
public class Blog extends Timestamped{

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author; //아이디
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String content;

    public Blog(String title,String author, String password, String content) {
        this.title = title;
        this.author = author;
        this.password = password;
        this.content = content;
    }
    public void update(BlogRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }
    public Blog(BlogRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }
}

