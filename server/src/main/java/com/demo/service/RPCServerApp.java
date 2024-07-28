package com.demo.service;


import com.demo.entry.ServiceProvider;
import com.demo.service.Impl.BlogServiceImpl;
import com.demo.service.Impl.UserServiceImpl;
import com.demo.service.netty.NettyRPCServer;

public class RPCServerApp {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer rpcServer = new NettyRPCServer(serviceProvider);
        rpcServer.start(8899);
    }
}
