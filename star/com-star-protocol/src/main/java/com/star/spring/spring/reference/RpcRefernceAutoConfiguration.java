package com.star.spring.spring.reference;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
@Configuration
public class RpcRefernceAutoConfiguration implements EnvironmentAware{

    @Bean
    public SpringRpcReferencePostProcessor postProcessor(){
        String address=environment.getProperty("gp.serviceAddress");
        int port=Integer.parseInt(environment.getProperty("gp.servicePort"));
        RpcClientProperties rc=new RpcClientProperties();
        rc.setServiceAddress(address);
        rc.setServicePort(port);
        rc.setRegistryType(Byte.parseByte(environment.getProperty("gp.registryType")));
        rc.setRegistryAddress(environment.getProperty("gp.registryAddress"));
        return new SpringRpcReferencePostProcessor(rc);
    }

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment=environment;
    }
}
