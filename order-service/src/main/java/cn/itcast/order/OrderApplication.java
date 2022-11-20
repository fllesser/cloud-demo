package cn.itcast.order;

import cn.itcast.feign.clients.UserServiceClient;
import cn.itcast.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients(
        clients = {UserServiceClient.class},
        defaultConfiguration = DefaultFeignConfiguration.class
)
@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }


    /**
     * 创建RestTemplate到容器
     * @return
     */
    @Bean
    @LoadBalanced //Ribbon负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//
//    @Bean
//    public IRule randomRule() {
//        return new RandomRule();
//    }
}