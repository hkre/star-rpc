package com.star.core.registry;


import com.star.core.common.URL;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
public interface Registry extends RegistryService, DiscoveryService {

    URL getUrl();

    void close();
}
