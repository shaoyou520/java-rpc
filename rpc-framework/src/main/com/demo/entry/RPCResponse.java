package com.demo.entry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class RPCResponse implements Serializable {

    // 状态信息
    private int code;
    private String message;
    // 具体数据
    private Object data;
    // 更新,这里我们需要加入这个，不然用其它序列化方式（除了java Serialize）得不到data的type
    private Class<?> dataType;

    public static RPCResponse success(Object data) {
        if (data == null) {
            return RPCResponse.builder().code(200).data(data).build();
        }
        return RPCResponse.builder().code(200).dataType(data.getClass()).data(data).build();
    }
    public static RPCResponse fail() {
        return RPCResponse.builder().code(500).message("服务器发生错误").build();
    }
}
