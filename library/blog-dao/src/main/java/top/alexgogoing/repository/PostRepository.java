package top.alexgogoing.repository;

import top.alexgogoing.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author alexgogoing  <a href="mailto:alexgogoing@sina.com">Contact me.</a>
 * @version 1.0
 * @since 2019/09/02
 */
@Component
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleLike(String title);

}
