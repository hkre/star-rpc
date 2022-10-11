package com.star.core.rpc;


import com.star.core.core.Request;
import com.star.core.core.Response;

/**
 *
 * @author Ricky Fung
 */
public interface Caller<T> extends Node {

    Class<T> getInterface();

    Response call(Request request);

}
