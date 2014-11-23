/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.login.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author KMM
 */
public class PageFilter implements Filter{

    private FilterConfig filterConfig;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            System.out.println("Enter");
            request.setAttribute("page", "Filter");
            
            chain.doFilter(request, response);
            System.out.println("Filter End");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");
    }
    
}
