package com.yitonglin.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yitonglin.service.client.UserClient;
import com.yitonglin.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("consumer/user")
@RestController
@DefaultProperties(defaultFallback = "FallBack")
public class UserController {


//    @Autowired
//    private RestTemplate restTemplate;


    @Autowired
    private UserClient userClient;

    //由于引导类中已经开启了负载均衡注解配置，所以此处注释掉
//    @Autowired
//    private DiscoveryClient discoveryClient;//Eureka客户端，用于拉取Eureka上的服务列表

//    @GetMapping
//    public User findUserById(@RequestParam("id")Long id){
//
////        //根据服务名称获取服务实例，因为有可能是集群，所以说是Service集合
////        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
////        //根据index获取实例，此处因为只有一个实例，所以使用了get（0）
////        ServiceInstance instance = instances.get(0);
//        //获取IP和端口信息，拼接成服务地址
//        //String baseUrl = "http://"+ instance.getHost() +":"+ instance.getPort() + "/user/" + id;
//
//        //此处使用负载均衡Ribbon
//        String baseUrl = "http://service-provider/user/" + id;
//        System.out.println("---------->"+baseUrl);
//        return restTemplate.getForObject(baseUrl,User.class);
//    }


    /**
     * 测试熔断局部方法区域
     * @param id
     * @return
     */
    //被熔断方法
    @GetMapping
    //此括号内的内容为设置本方法的熔断方法，若不设置但此注解必须保留方可使用熔断方法，此时会使用全局熔断方法
    //@HystrixCommand(fallbackMethod = "queryUserByIdFallBack")
    //@HystrixCommand
    public String queryUserById(@RequestParam("id") Long id) {
        //String user = this.restTemplate.getForObject("http://service-provider/user/" + id, String.class);
        User user = this.userClient.queryUserById(id);
        return user.toString();
    }

    @GetMapping("work")
    public String test(@RequestParam("test") String test){
        System.out.println("---------->已访问");
        return this.userClient.test(test);
    }

    //熔断方法
    public String queryUserByIdFallBack(Long id){
        return "局部熔断方法:  请求繁忙，请稍后再试！";
    }

    /**
     * 测试全局熔断方法区域
     */
    //熔断方法 全局熔断方法不可设置参数列表
    public String FallBack(){
        return "全局熔断方法:  请求繁忙，请稍后再试！";
    }



}
