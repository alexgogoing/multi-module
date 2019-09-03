package top.alexgogoing.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author alexgogoing  <a href="mailto:alexgogoing@sina.com">Contact me.</a>
 * @version 1.0
 * @since 2019/09/02
 */
@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    private Long id;
    private String title;
    private String content;
}
