package com.demo;

import com.demo.client.netty.NettyRPCClient;
import com.demo.entry.Blog;
import com.demo.entry.User;
import com.demo.service.BlogService;
import com.demo.client.ClientProxy;
import com.demo.service.UserService;

public class RPCClient {
    public static void main(String[] args) {
        try {
            ClientProxy clientProxy = new ClientProxy(new NettyRPCClient("127.0.0.1", 8899));
            UserService userService = clientProxy.getProxy(UserService.class);
            User user = userService.getUserById("99");
            System.out.println("服务端返回的User:"+user);
            user = userService.getUserById("100");
            System.out.println("服务端返回的User:"+user);
            BlogService blogService = clientProxy.getProxy(BlogService.class);
            Blog blog = blogService.getBlogById(97);
            System.out.println("服务端返回的User:"+ blog);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("客户端启动失败");
        }
    }
}
