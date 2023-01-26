package com.nongshim.nds.springboot.web;

import com.nongshim.nds.springboot.domain.posts.Posts;
import com.nongshim.nds.springboot.domain.posts.PostsRepository;
import com.nongshim.nds.springboot.web.Dto.PostSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 스프링 부트 테스트에서는 정적 포트를 사용하면 안됨.
 * 따라서 webEnvironment필드를 사용하여 랜덤포트로 설정하는 부분
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {
    @LocalServerPort // 테스트에 포트 번호를 삽입
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void tearDown(){
        postsRepository.deleteAll();
    }

    @Test
    void Posts_등록된다() throws Exception {
        String title = "title";
        String content = "content";
        String author = "author";
        PostSaveRequestDto requestDto = PostSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
        String url = "http://localhost:" + port + "/api/v1/posts";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> postsList = postsRepository.findAll();
        assertThat(postsList.get(0).getTitle()).isEqualTo(title);
        assertThat(postsList.get(0).getContent()).isEqualTo(content);
        assertThat(postsList.get(0).getAuthor()).isEqualTo(author);
    }
}
