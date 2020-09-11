package com.yitonglin.service.client;

import com.yitonglin.service.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

//标注该类是一个feign接口并设置服务提供方分的id用于取注册中心拉去下来的服务列表中寻找服务的IP和端口
//此处的第二个参数为将熔断配置方法与此代替Restteamplate的Fegin相连接
@FeignClient(value = "service-provider",fallback = UserClientFallback.class)
public interface UserClient {
    @GetMapping("user/{id}")
    User queryUserById(@PathVariable("id")Long id);

    @GetMapping("user/test?test1={test}")
    String test(@PathVariable("test")String test);
}
