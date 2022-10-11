package com.star.core.rpc;

import com.google.common.collect.ArrayListMultimap;
import com.star.core.cluster.Cluster;
import com.star.core.common.URL;
import com.star.core.core.extension.SPI;
import com.star.core.util.Constants;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
@SPI(Constants.DEFAULT_VALUE)
public interface ConfigHandler {

    <T> Cluster<T> buildCluster(Class<T> interfaceClass, URL refUrl, List<URL> registryUrls);

    /**
     * 引用服务
     * @param interfaceClass
     * @param cluster
     * @param <T>
     * @return
     */
    <T> T refer(Class<T> interfaceClass, List<Cluster<T>> cluster, String proxyType);

    /**
     * 暴露服务
     * @param interfaceClass
     * @param ref
     * @param serviceUrl
     * @param registryUrls
     * @param <T>
     * @return
     */
    <T> Exporter<T> export(Class<T> interfaceClass, T ref, URL serviceUrl, List<URL> registryUrls);

    <T> void unexport(List<Exporter<T>> exporters, ArrayListMultimap<URL, URL> registryUrls);

}
