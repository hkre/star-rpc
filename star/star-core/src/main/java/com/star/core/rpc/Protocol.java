package com.star.core.rpc;

import com.star.core.common.URL;
import com.star.core.core.extension.SPI;
import com.star.core.util.Constants;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
@SPI(value = Constants.FRAMEWORK_NAME)
public interface Protocol {

    <T> Reference<T> refer(Class<T> clz, URL url, URL serviceUrl);

    <T> Exporter<T> export(Provider<T> provider, URL url);

    void destroy();
}
