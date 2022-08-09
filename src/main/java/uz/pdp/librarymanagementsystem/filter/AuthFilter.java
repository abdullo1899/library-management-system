package uz.pdp.librarymanagementsystem.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@WebFilter({"/","/books", "/student-reports", "/admin-reports"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = resp.getWriter();

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getServletPath();


        HttpSession session = request.getSession();
        Boolean isAuthenticated = (Boolean) session.getAttribute("isAuthenticated");

        if (Objects.nonNull(isAuthenticated) || isPublicPage(path)) {
            filterChain.doFilter(req, resp);

            return;
        } else {
            response.sendRedirect("/login");
        }
    }

    private boolean isPublicPage(String path) {
        List<String> publicPages = Arrays.asList("/", "/login");
        // TODO: 7/27/2022 create home page

        return publicPages.contains(path);
    }

    @Override
    public void destroy() {

    }

}
