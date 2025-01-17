package com.demo;

import com.demo.client.impl.netty.NettyRPCClient;
import com.demo.entry.Blog;
import com.demo.entry.User;
import com.demo.service.BlogService;
import com.demo.client.impl.ClientProxy;
import com.demo.service.UserService;

import java.util.List;

public class RPCClient {
    public static void main(String[] args) {
        try {
            ClientProxy clientProxy = new ClientProxy(new NettyRPCClient());
//            UserService userService = clientProxy.getProxy(UserService.class);
//            User user = userService.getUserById("99");
//            System.out.println("服务端返回的User:"+user);
//
//            user = userService.getUserById("100");
//            System.out.println("服务端返回的User:"+user);

            BlogService blogService = clientProxy.getProxy(BlogService.class);
//            Blog blog = blogService.getBlogById(97);
//            System.out.println("服务端返回的User:"+ blog);

            blogService.printDate();
//            System.out.println("服务端返回的User:"+ lists);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("客户端启动失败");
        }
    }
}
