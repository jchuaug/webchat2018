package com.xmu.middleware.webchat2018.intecepter;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class HttpHandShakeIntecepter implements HandshakeInterceptor {
    /**
     *
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @param webSocketHandler
     * @param e
     */
    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e)
    {
        System.out.println("【握手拦截器】afterHandshake");
        if(serverHttpRequest instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest)serverHttpRequest;
            HttpSession session =  servletRequest.getServletRequest().getSession();
            String sessionId = session.getId();
            System.out.println("【握手拦截器】afterHandshake sessionId="+sessionId);
        }
    }

    /**
     * http握手拦截器，可以通过这个类的方法获取resuest,和response
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @param webSocketHandler
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        System.out.println("【握手拦截器】beforeHandshake");
        if(serverHttpRequest instanceof ServletServerHttpRequest){
           ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) serverHttpRequest;
           HttpSession session=servletRequest.getServletRequest().getSession();
            String sessionId=session.getId();
            System.out.println("【握手拦截器】beforeHandshake");
            map.put("sessionId",sessionId);
        }
        return true;
    }
}
