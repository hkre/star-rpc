package com.star.core.registry;


import com.star.core.common.URL;

import java.util.List;

/**
 * @author Ricky Fung
 */
public interface NotifyListener {

    void notify(URL registryUrl, List<URL> urls);
}
