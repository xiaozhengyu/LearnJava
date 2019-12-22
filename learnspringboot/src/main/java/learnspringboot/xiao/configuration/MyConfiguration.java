package learnspringboot.xiao.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 肖政宇
 * @date 2019-10-10 10:32
 * 说明：我的配置类
 * EnableWebMvc - 开启对SpringMVC的配置支持
 */
@Configuration
@EnableWebMvc
public class MyConfiguration implements WebMvcConfigurer {

}
