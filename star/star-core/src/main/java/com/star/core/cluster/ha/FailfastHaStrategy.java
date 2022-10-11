package com.star.core.cluster.ha;


import com.star.core.cluster.HaStrategy;
import com.star.core.cluster.LoadBalance;
import com.star.core.core.Request;
import com.star.core.core.Response;
import com.star.core.rpc.Reference;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
public class FailfastHaStrategy<T> implements HaStrategy<T> {

    @Override
    public Response call(Request request, LoadBalance loadBalance) {
        Reference<T> reference = loadBalance.select(request);
        return reference.call(request);
    }
}
