package com.nongshim.nds.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<Entity클래스, PK타입>을 상속하면 기본적인 CRUD 메소드가 자동 생성됨
// Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수 없음
@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
