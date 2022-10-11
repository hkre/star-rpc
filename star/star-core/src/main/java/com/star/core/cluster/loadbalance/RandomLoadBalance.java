package com.star.core.cluster.loadbalance;



import com.star.core.cluster.LoadBalance;
import com.star.core.core.Request;
import com.star.core.rpc.Reference;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
public class RandomLoadBalance<T> implements LoadBalance<T> {
    private volatile List<Reference<T>> references;

    @Override
    public void setReferences(List<Reference<T>> references) {
        this.references = references;
    }

    @Override
    public Reference select(Request request) {
        int idx = (int) (ThreadLocalRandom.current().nextDouble() * references.size());
        return references.get(idx);
    }
}
