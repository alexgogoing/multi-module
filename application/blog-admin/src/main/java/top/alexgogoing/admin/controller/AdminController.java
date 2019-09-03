package top.alexgogoing.admin.controller;

import top.alexgogoing.entity.Post;
import top.alexgogoing.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author alexgogoing  <a href="mailto:alexgogoing@sina.com">Contact me.</a>
 * @version 1.0
 * @since 2019/09/02
 */
@RestController
@RequestMapping("/admin/post")
public class AdminController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> findAll() {
        return postService.findAll();
    }

}
