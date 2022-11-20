package cn.itcast.order.service;

import cn.itcast.feign.clients.UserServiceClient;
import cn.itcast.feign.pojo.User;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

//    @Resource
//    private RestTemplate restTemplate;

    @Resource
    private UserServiceClient userServiceClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        /*String url = "http://localhost:8091/user/" + order.getUserId();
        String url = "http://userservice/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);*/
        // 使用feign远程调用
        User user = userServiceClient.findById(order.getUserId());
        order.setUser(user);
        // 4.返回
        return order;
    }
}
