package com.star.core.cluster;


import com.star.core.core.extension.SPI;
import com.star.core.core.extension.Scope;
import com.star.core.rpc.Caller;
import com.star.core.rpc.Reference;

import java.util.List;

/**
 * @author Ricky Fung
 */
@SPI(scope = Scope.PROTOTYPE)
public interface Cluster<T> extends Caller<T> {

    void setLoadBalance(LoadBalance<T> loadBalance);

    void setHaStrategy(HaStrategy<T> haStrategy);

    List<Reference<T>> getReferences();

    LoadBalance<T> getLoadBalance();
}
