package com.demo.entry;

import java.util.HashMap;
import java.util.Map;

public class ServiceProvider {
    /**
     * 一个实现类可能实现多个接口
     */
    private Map<String, Object> interfaceProvider = null;

    public ServiceProvider(){
        this.interfaceProvider = new HashMap<>();
    }

    public void provideServiceInterface(Object service){
        Class<?>[] interfaces = service.getClass().getInterfaces();

        for(Class clazz : interfaces){
            interfaceProvider.put(clazz.getName(),service);
        }

    }

    public Object getService(String interfaceName){
        return interfaceProvider.get(interfaceName);
    }
}
