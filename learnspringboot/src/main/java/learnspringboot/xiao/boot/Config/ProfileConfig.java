package learnspringboot.xiao.boot.Config;

import learnspringboot.xiao.boot.Service.DemoBeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author xzy
 * @date 2019-11-22 10:40
 * 说明：Profile配置
 */
@Configuration
public class ProfileConfig {
    @Bean
    @Profile("dev")
    public DemoBeanService devDemoBean() {
        //profile为dev时实例化
        return new DemoBeanService("from development profile");
    }

    @Bean
    @Profile("prod")
    public DemoBeanService prodDemoBean() {
        //profile为prod时实例化
        return new DemoBeanService("from production profile");
    }
}
