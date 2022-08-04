package sparta.week4homework.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.week4homework.dto.PostResponseDto;
import sparta.week4homework.entitiy.Post;
import sparta.week4homework.entitiy.User;
import sparta.week4homework.repository.PostRepository;
import sparta.week4homework.dto.PostRequestDto;
import sparta.week4homework.repository.UserRepository;



@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    /* CREATE */
    @Transactional
    public Long save(PostRequestDto dto, String username) {
        /* User 정보를 가져와 dto에 담아준다. */
        User user = userRepository.findByUsername(username);
        dto.setUser(user);
        log.info("PostsService save() 실행");
        Post posts = dto.toEntity();
        postRepository.save(posts);

        return posts.getId();
    }

    /* READ 게시글 리스트 조회 readOnly 속성으로 조회속도 개선 */
    @Transactional(readOnly = true)
    public PostResponseDto findById(Long id) {
        Post posts = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));

        return new PostResponseDto(posts);
    }

    /* UPDATE (dirty checking 영속성 컨텍스트)
     *  User 객체를 영속화시키고, 영속화된 User 객체를 가져와 데이터를 변경하면
     * 트랜잭션이 끝날 때 자동으로 DB에 저장해준다. */
    @Transactional
    public void update(Long id, PostRequestDto dto) {
        Post posts = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));

        posts.update(dto.getTitle(), dto.getContent());
    }

    /* DELETE */
    @Transactional
    public void delete(Long id) {
        Post posts = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));

        postRepository.delete(posts);
    }


    /* Paging and Sort */
    @Transactional(readOnly = true)
    public Page<Post> pageList(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    /* search */
    @Transactional(readOnly = true)
    public Page<Post> search(String keyword, Pageable pageable) {
        Page<Post> postsList = postRepository.findByTitleContaining(keyword, pageable);
        return postsList;
    }
}