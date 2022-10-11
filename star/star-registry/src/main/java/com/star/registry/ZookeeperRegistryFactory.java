package com.star.registry;

import com.star.core.common.URL;
import com.star.core.common.URLParam;
import com.star.core.registry.AbstractRegistryFactory;
import com.star.core.registry.Registry;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkException;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
public class ZookeeperRegistryFactory extends AbstractRegistryFactory {

    @Override
    protected Registry createRegistry(URL registryUrl) {
        try {
            int timeout = registryUrl.getIntParameter(URLParam.registryConnectTimeout.getName(), URLParam.registryConnectTimeout.getIntValue());
            int sessionTimeout =
                    registryUrl.getIntParameter(URLParam.registrySessionTimeout.getName(),
                            URLParam.registrySessionTimeout.getIntValue());
            ZkClient zkClient = new ZkClient(registryUrl.getParameter(URLParam.registryAddress.getName()), sessionTimeout, timeout);
            return new ZookeeperRegistry(registryUrl, zkClient);
        } catch (ZkException e) {
            throw e;
        }
    }
}
