package top.alexgogoing.repository.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author alexgogoing  <a href="mailto:alexgogoing@sina.com">Contact me.</a>
 * @version 1.0
 * @since 2019/09/02
 */
@Configuration
@EnableJpaRepositories(basePackages = "top.alexgogoing")
@EntityScan(basePackages = "top.alexgogoing")
public class RepositoryConfiguration {
}
