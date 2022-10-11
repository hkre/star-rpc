package com.star.core.rpc;


import com.star.core.common.URL;
import com.star.core.core.DefaultResponse;
import com.star.core.core.Request;
import com.star.core.core.Response;
import com.star.core.exception.RpcBizException;
import com.star.core.exception.RpcFrameworkException;

import java.lang.reflect.Method;

/**
 * @author Ricky Fung
 */
public class DefaultProvider<T> extends AbstractProvider<T> {
    protected T proxyImpl;

    public DefaultProvider(T proxyImpl, URL url, Class<T> clz) {
        super(url, clz);
        this.proxyImpl = proxyImpl;
    }

    @Override
    public Class<T> getInterface() {
        return clz;
    }

    @Override
    public Response invoke(Request request) {

        DefaultResponse response = new DefaultResponse();
        response.setRequestId(request.getRequestId());

        Method method = lookup(request);
        if (method == null) {
            RpcFrameworkException exception =
                    new RpcFrameworkException("Service method not exist: " + request.getInterfaceName() + "." + request.getMethodName());

            response.setException(exception);
            return response;
        }
        try {
            method.setAccessible(true);
            Object result = method.invoke(proxyImpl, request.getArguments());
            response.setResult(result);
        } catch (Exception e) {
            response.setException(new RpcBizException("invoke failure", e));
        }
        return response;
    }
}
