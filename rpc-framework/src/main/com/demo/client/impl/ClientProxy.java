package com.demo.client.impl;

import com.demo.client.RPCClient;
import com.demo.entry.RPCResponse;
import com.demo.entry.RPCRequest;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@AllArgsConstructor
public class ClientProxy implements InvocationHandler {

    private RPCClient client;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RPCRequest request = RPCRequest.builder().interfaceName(
                method.getDeclaringClass().getName())
                .methodName(method.getName())
                .params(args).paramsTypes(method.getParameterTypes()).build();
        //数据传输
        RPCResponse response = client.sendRequest(request);
        System.out.println(response);
        return response.getData();
    }

    public <T>T getProxy(Class<T> clazz){
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T)o;
    }
}
