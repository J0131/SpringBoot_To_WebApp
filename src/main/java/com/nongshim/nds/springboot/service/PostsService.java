package com.nongshim.nds.springboot.service;


import com.nongshim.nds.springboot.domain.posts.Posts;
import com.nongshim.nds.springboot.domain.posts.PostsRepository;
import com.nongshim.nds.springboot.web.Dto.PostSaveRequestDto;
import com.nongshim.nds.springboot.web.Dto.PostsResponseDto;
import com.nongshim.nds.springboot.web.Dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
