package com.nongshim.nds.springboot.web;


import com.nongshim.nds.springboot.service.PostsService;
import com.nongshim.nds.springboot.web.Dto.PostSaveRequestDto;
import com.nongshim.nds.springboot.web.Dto.PostsResponseDto;
import com.nongshim.nds.springboot.web.Dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApicontroller {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public long save(@RequestBody PostSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }
}
