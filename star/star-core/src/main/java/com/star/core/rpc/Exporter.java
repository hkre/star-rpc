package com.star.core.rpc;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
public interface Exporter<T> extends Node {

    Provider<T> getProvider();

    void unexport();
}
