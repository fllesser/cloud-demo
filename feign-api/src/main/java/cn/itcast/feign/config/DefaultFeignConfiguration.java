package cn.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * Feign 的配置类
 * 全局配置 在启动类中
 * ** @EnableFeignClients(defaultConfiguration = FeignClientConfiguration.class)
 * 局部配置 在Client接口中
 * ** @FeignClient(value = "userservice", configuration = FeignClientConfiguration.class)
 */
public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level feignLogLevel() {
        return Logger.Level.BASIC;
    }


}
