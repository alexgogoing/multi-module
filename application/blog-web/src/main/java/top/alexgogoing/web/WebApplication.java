package top.alexgogoing.web;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

/**
 * @author alexgogoing  <a href="mailto:alexgogoing@sina.com">Contact me.</a>
 * @version 1.0
 * @since 2019/09/02
 */
@SpringBootApplication(scanBasePackages = "top.alexgogoing")
public class WebApplication {

    private final static Logger logger = Logger.getLogger(WebApplication.class);

    private static ConfigurableApplicationContext context;

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    public static void main(String[] args) {
        Class<?>[] resources = new Class<?>[]{WebApplication.class};
        context = SpringApplication.run(resources, args);
        logger.info("\u001b[34m ::ALEXGOGOING:: \u001b[31m ========== \u001b[32m Server started at \u001b[33m " + new Date() + " \u001b[0m");
    }

}
