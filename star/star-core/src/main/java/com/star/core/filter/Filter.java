package com.star.core.filter;

import com.star.core.core.Request;
import com.star.core.core.Response;
import com.star.core.core.extension.SPI;
import com.star.core.rpc.Caller;

/**
 * @author Ricky Fung
 */
@SPI
public interface Filter {

    Response filter(Caller<?> caller, Request request);

}
