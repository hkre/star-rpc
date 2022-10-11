package com.star.core.codec;


import com.star.core.common.URL;
import com.star.core.core.extension.SPI;
import com.star.core.util.Constants;

import java.io.IOException;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
@SPI(Constants.FRAMEWORK_NAME)
public interface Codec {

    byte[] encode(URL url, Object message) throws IOException;

    Object decode(URL url, byte messageType, byte[] data) throws IOException;
}
