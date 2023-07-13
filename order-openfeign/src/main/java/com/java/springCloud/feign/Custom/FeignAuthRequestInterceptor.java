package com.java.springCloud.feign.Custom;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignAuthRequestInterceptor implements RequestInterceptor {
    Logger l = LoggerFactory.getLogger(this.getClass());

    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.uri("4");
    }
}
