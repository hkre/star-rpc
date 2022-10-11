package com.star.core.cluster;

import com.star.core.core.Request;
import com.star.core.core.extension.SPI;
import com.star.core.core.extension.Scope;
import com.star.core.rpc.Reference;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
@SPI(scope = Scope.PROTOTYPE)
public interface LoadBalance<T> {

    void setReferences(List<Reference<T>> references);

    Reference<T> select(Request request);
}
