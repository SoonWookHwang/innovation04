package sparta.week4homework.entitiy;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import sparta.week4homework.dto.CommentRequestDto;


import javax.persistence.*;

//@Setter
//@Getter // get 함수를 일괄적으로 만들어줍니다.
//@NoArgsConstructor // 기본 생성자를 만들어줍니다.
//@AllArgsConstructor
//@Entity // DB 테이블 역할을 합니다.
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "comments")
@Entity
public class Comment extends Timestamped {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    private Long id;
//
//    @Column(nullable = false)
//    private Long postId;
//
//    @Column(nullable = false)
//    private String comment;
//
//
//    @ManyToOne    @JoinColumn(name = "posts_id")
//    private Post post;
//
//    @ManyToOne    @JoinColumn(name = "user_id")
//    private User user; // 작성자

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment; // 댓글 내용


    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Post posts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 작성자


    public void update(String comment) {
        this.comment = comment;
    }
}

