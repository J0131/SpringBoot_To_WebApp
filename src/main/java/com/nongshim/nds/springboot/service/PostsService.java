package com.nongshim.nds.springboot.service;


import com.nongshim.nds.springboot.domain.posts.PostsRepository;
import com.nongshim.nds.springboot.web.Dto.PostSaveRequestDto;
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
}
