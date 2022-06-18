/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author Matt
 */
public class LoginServlet extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set up the session
        HttpSession session = request.getSession();
        
        
        if( request.getParameter("logout") != null ){
            
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
            return;
            
        }
       
        // load the JSP
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if( username == null || password == null || username.equals("") || password.equals("")){
            
            session.setAttribute("message", "Please enter both username and password.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
            return;
            
        }
        AccountService loginservice = new AccountService();
        User account = loginservice.login(username, password);
        if(account != null){
            session.setAttribute("username", username);
            response.sendRedirect("home");
            return;
        }
        else{
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            session.setAttribute("message", "Username or password are incorrect.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
            return;
        }
    }

    

}
