package com.nongshim.nds.springboot.web;


import com.nongshim.nds.springboot.service.PostsService;
import com.nongshim.nds.springboot.web.Dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApicontroller {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public long save(@RequestBody PostSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
}
