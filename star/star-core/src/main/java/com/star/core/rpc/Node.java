package com.star.core.rpc;


import com.star.core.common.URL;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
public interface Node {

    void init();

    void destroy();

    boolean isAvailable();

    String desc();

    URL getUrl();
}
