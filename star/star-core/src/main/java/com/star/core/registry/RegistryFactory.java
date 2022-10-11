package com.star.core.registry;


import com.star.core.common.URL;
import com.star.core.core.extension.SPI;
import com.star.core.core.extension.Scope;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
@SPI(scope = Scope.SINGLETON)
public interface RegistryFactory {

    Registry getRegistry(URL url);
}
