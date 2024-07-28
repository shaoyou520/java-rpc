package com.demo.client;


import com.demo.entry.RPCRequest;
import com.demo.entry.RPCResponse;

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}
