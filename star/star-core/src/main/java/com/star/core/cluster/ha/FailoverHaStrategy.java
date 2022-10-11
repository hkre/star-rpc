package com.star.core.cluster.ha;

import com.star.core.cluster.HaStrategy;
import com.star.core.cluster.LoadBalance;
import com.star.core.common.URL;
import com.star.core.common.URLParam;
import com.star.core.core.Request;
import com.star.core.core.Response;
import com.star.core.exception.RpcFrameworkException;
import com.star.core.rpc.Reference;
import com.star.core.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
public class FailoverHaStrategy<T> implements HaStrategy<T> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Response call(Request request, LoadBalance loadBalance) {
        Reference<T> reference = loadBalance.select(request);
        URL refUrl = reference.getUrl();
        int tryCount = refUrl.getIntParameter(URLParam.retries.getName(), URLParam.retries.getIntValue());
        if(tryCount<0){
            tryCount = 0;
        }
        for (int i = 0; i <= tryCount; i++) {
            reference = loadBalance.select(request);
            try {
                return reference.call(request);
            } catch (RuntimeException e) {
                // 对于业务异常，直接抛出
                if (ExceptionUtil.isBizException(e)) {
                    throw e;
                } else if (i >= tryCount) {
                    throw e;
                }
                logger.warn(String.format("FailoverHaStrategy Call false for request:%s error=%s", request, e.getMessage()));
            }
        }
        throw new RpcFrameworkException("FailoverHaStrategy.call should not come here!");
    }
}
