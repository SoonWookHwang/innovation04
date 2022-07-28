package sparta.myblogbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BlogRequestDto {
    private String title;
    private String author;
    private String password;
    private String content;

    public BlogRequestDto(String title, String content, String author, String password) {
        this.title = title;
        this.author = author;
        this.password = password;
        this.content = content;
    }



}
