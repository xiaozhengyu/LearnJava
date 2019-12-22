package learnspringboot.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.spring4all.swagger.EnableSwagger2Doc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2Doc
@EnableSwagger2
public class XiaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoApplication.class, args);
    }
}
