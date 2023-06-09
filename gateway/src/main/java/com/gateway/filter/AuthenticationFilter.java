package com.gateway.filter;

import com.feign_api.utils.Jwt;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 权限认证过滤器
 */
@Order(-1)
@Component
public class AuthenticationFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        //登录 注册 看书 直接放行
        if(request.getURI().getPath().contains("/login")
                || request.getURI().getPath().contains("/register")
                || request.getURI().getPath().contains("/download")
                || request.getURI().getPath().contains("/select")
//                || request.getURI().getPath().contains("/selectBook")
        ){
            //放行
            return chain.filter(exchange);
        }

        HttpHeaders headers = request.getHeaders();
        //请求头使用 myBooksToken
        String token = headers.getFirst("myBooksToken");
        //判断令牌是否存在
        if(token == null || "".equals(token)){
            //没有令牌 返回未登录提示
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        //令牌存在 解析
        boolean parse = Jwt.parse(token);
        if (!parse){
            //令牌过期、错误，返回未登录提示
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        //放行
        return chain.filter(exchange);
    }
}
