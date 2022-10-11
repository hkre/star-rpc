package com.star.core.cluster;


import com.star.core.core.Request;
import com.star.core.core.Response;
import com.star.core.core.extension.SPI;
import com.star.core.core.extension.Scope;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
@SPI(scope = Scope.PROTOTYPE)
public interface HaStrategy<T> {

    Response call(Request request, LoadBalance loadBalance);
}
