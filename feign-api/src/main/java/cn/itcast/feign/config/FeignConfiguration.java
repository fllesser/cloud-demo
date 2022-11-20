package cn.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {

    @Bean
    public Logger.Level feignLogLevel() {
        return Logger.Level.NONE;
    }
}
