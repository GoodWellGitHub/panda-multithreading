package com.org.java_concurrentcy_in_practice.service;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class VolatileCachedFactorizer implements Servlet {
    private volatile OneValueCache cache=new OneValueCache(null,null);
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i=extractFromRequest(servletRequest);
        BigInteger[] factors=cache.getLastFactors(i);
        if (factors==null){
            factors= null;
            cache=null;
        }
        dosomething();

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }

    private BigInteger extractFromRequest(ServletRequest request){
        return new BigInteger("12");
    }
    private void dosomething(){

    }


}
