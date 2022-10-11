package com.star.core.transport;


import com.star.core.core.Request;
import com.star.core.core.Response;
import com.star.core.core.ResponseFuture;
import com.star.core.exception.TransportException;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
public interface NettyClient extends Endpoint {

    Response invokeSync(final Request request)
            throws InterruptedException, TransportException;

    ResponseFuture invokeAsync(final Request request)
            throws InterruptedException, TransportException;

    void invokeOneway(final Request request)
            throws InterruptedException, TransportException;

}
