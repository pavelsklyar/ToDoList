package servlets.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyEncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("my encoding filter");
        chain.doFilter(request, response);
    }
}
