package com.nongshim.nds.springboot.domain.posts;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    /**
     * Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
     * 보통은 배포 전 전체 테스트를 수행할 때 테스트 간 데이터 침범을 막기 위해 사용
     // 여러 테스트가 동시에 수행되면 테스트용 데이터베이스인 H2가 데이터에 그대로 남아있어
        다음 테스트 실행 시 테스트가 실패할 수 있다
     *
     */

    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    void 게시글저장_불러오기() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        /**
         * 테이블 post에 insert/update 쿼리를 실행
         * id값이 있다면 update가, 없다면 insert쿼리가 실행
         */
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build()
        );

        List<Posts> postsList = postsRepository.findAll();
        // 테이블 posts에 있는 모든 데이터를 조회해오는 메소드

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
