package com.appsdeveloperblog.rentalapp.api.geteway;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory {

    @Override
    public GatewayFilter apply(Object config) {

        System.out.println("filter calıstı");

        return null;
    }
}
