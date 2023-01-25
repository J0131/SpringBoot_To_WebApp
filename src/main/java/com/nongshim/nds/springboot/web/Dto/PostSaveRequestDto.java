package com.nongshim.nds.springboot.web.Dto;


import com.nongshim.nds.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;

    // PostSaveRequestDto의 생성자에 Builder를 붙이기
    @Builder
    PostSaveRequestDto(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Posts 생성자에 정의된 Builder() 사용
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
