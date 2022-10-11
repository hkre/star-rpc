package com.star.core.rpc;


import com.star.core.core.Request;
import com.star.core.core.Response;

/**
 * @author Ricky Fung
 */
public interface MessageHandler {

    Response handle(Request request);

}
