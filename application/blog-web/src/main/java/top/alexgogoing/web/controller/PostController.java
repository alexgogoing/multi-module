package top.alexgogoing.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.alexgogoing.entity.Post;
import top.alexgogoing.service.PostService;

import java.util.Optional;

/**
 * @author alexgogoing  <a href="mailto:alexgogoing@sina.com">Contact me.</a>
 * @version 1.0
 * @since 2019/09/02
 */
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Long id) {
        Optional<Post> optionalPost = postService.findById(id);
        return optionalPost.orElse(null);
    }
}
