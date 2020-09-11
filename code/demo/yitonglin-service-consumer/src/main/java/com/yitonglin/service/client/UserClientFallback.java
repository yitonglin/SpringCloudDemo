package com.yitonglin.service.client;

import com.yitonglin.service.pojo.User;
import org.springframework.stereotype.Component;

//此类为UserClient的熔断配置类
@Component
public class UserClientFallback  implements UserClient{

    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setUsername("Feign中的熔断---->服务器繁忙请稍后再试......");
        return user;
    }

    @Override
    public String test(String test) {
        return "Feign测试熔断--->服务器繁忙请稍后再试......";
    }
}
