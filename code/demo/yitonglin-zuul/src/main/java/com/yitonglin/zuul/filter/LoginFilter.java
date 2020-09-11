package com.yitonglin.zuul.filter;


import com.ctc.wstx.util.StringUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//过滤器类
@Component
public class LoginFilter extends ZuulFilter {


    /**
     * 过滤器类型 设置是前置过滤器还是别的几种过滤器
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     *过滤器优先级  越低优先级越高   一般设置高一些 方便后期拓展过滤器
     * @return
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *过滤器的逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //获取zuul提供的上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        //从上下文对象中获取请求对象
        HttpServletRequest request = requestContext.getRequest();
        //获取token信息
        String token = request.getParameter("token");
        //判断
        /**
         * 是否为 null
         * 是否为 “”
         * 是否为空字符串(引号中间有空格) 如： " "。
         * 制表符、换行符、换页符和回车
         *
         * StringUtils的isBlank()方法可以一次性校验这三种情况
         */
        if (StringUtils.isBlank(token)){
            //过滤该请求，不对其进行路由
            requestContext.setSendZuulResponse(false);
            //设置响应状态码 401
            requestContext.setResponseStatusCode(HttpStatus.SC_GONE);
            //设置响应信息
            requestContext.setResponseBody("{\\\"status\\\":\\\"401\\\", \\\"text\\\":\\\"request error!\\\"}");
        }
        return null;
    }
}
