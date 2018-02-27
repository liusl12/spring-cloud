package com.liusl.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther liusl12
 * @date 2018/2/26.
 */
public class AccessFilter extends ZuulFilter{
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤器类型
     * 决定了过滤器在请求的哪个生命周期中执行，这里返回的是“pre”，表示在
     * 请求被路由之前执行
     * @return
     */
    @Override
    public String filterType(){
        return "pre";
    }

    /**
     * 过滤器的执行顺序
     * 在请求的一个阶段中可能会存在多个过滤器，需要根据方法返回的值来依次执行
     * @return
     */
    @Override
    public int filterOrder(){
        return 0;
    }

    /**
     * 判断是否执行该过滤器
     * @return
     */
    @Override
    public boolean shouldFilter(){
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     */
    @Override
    public Object run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("send {} reuqest to {}",request.getMethod(),request.getRequestURI().toString());
        Object token = request.getParameter("accessToken");
        if(token == null){
            log.warn("access token is null!");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok!");
        return null;
    }
}
