package com.demo.service;


import com.demo.service.impl.ServiceProvider;
import com.demo.service.Impl.BlogServiceImpl;
import com.demo.service.Impl.UserServiceImpl;
import com.demo.service.impl.netty.NettyRPCServer;

public class RPCServerApp {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();
        ServiceProvider serviceProvider = new ServiceProvider("127.0.0.1", 8899);
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer rpcServer = new NettyRPCServer(serviceProvider);
        rpcServer.start(8899);
    }
}
