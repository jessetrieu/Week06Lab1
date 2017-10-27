/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 579957
 */
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        
        if (action != null && action.equals("logout")) {
            request.getSession().removeAttribute("user");
            request.setAttribute("logout", "You have successfully logged out.");
        }
        
        Cookie userNameCookie = getCookie(request.getCookies());
        
        if (userNameCookie != null && !userNameCookie.getValue().equals("")) {
            request.setAttribute("userName", userNameCookie.getValue());
            request.setAttribute("save", "checked");
        }
        
        User user = (User)session.getAttribute("user");
        if (user != null) {
            response.sendRedirect("home");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String[] saveCheck = request.getParameterValues("save");

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            request.setAttribute("userName", username);
            if (saveCheck !=null) {
                request.setAttribute("save", "checked");
            }
            request.setAttribute("errorMessage", "Invalid username or password!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
       
        UserService service = new UserService();
        User user = service.login(username, password);
       
        if (user == null) {
            request.setAttribute("userName", username);
            if (saveCheck != null) {
                request.setAttribute("save", "checked");
            }
            request.setAttribute("errorMessage", "Invalid username or password!");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

        if (saveCheck != null) {
            response.addCookie(new Cookie("user", username));
        }
        if (saveCheck == null) {      
            Cookie cookie = getCookie(request.getCookies());
            if (cookie != null) {        
                cookie.setMaxAge(0);
                cookie.setValue(null);
                response.addCookie(cookie);
            } 
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        response.sendRedirect("home");
    } 
    
    private Cookie getCookie(Cookie[] cookies) {
        Cookie userNameCookie = null;
        
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                userNameCookie = cookie;
            }
        }
        return userNameCookie;
    }
}
