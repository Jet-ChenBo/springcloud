package cn.itcast.order.clients;

import cn.itcast.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient("UserService") //服务名
//public interface UserClient {
//
//    @GetMapping("/user/{123}")
//    User findById(@PathVariable("123") Long id);
//}

@FeignClient("gateway") //服务名，调用网关
public interface UserClient {

    @GetMapping("/user/{123}")
    User findById(@PathVariable("123") Long id);
}
