/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.dao.LoginDAO;
import model.entity.Customer;

/**
 *
 * @author PC
 */
public class LoginServlet extends HttpServlet {

    private LoginDAO loginDAO = new LoginDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        System.out.println(url);
        switch (url) {
            case "/login":
                showLogin(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        System.out.println(url);
        switch (url) {
            case "/login":
                login(request, response);
                break;
            default:
                break;
        }
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        Customer cus = loginDAO.checkLogin(userName, passWord);
        if (cus != null) {
            HttpSession session = request.getSession();
            session.setAttribute("seeId", String.valueOf(cus.getIdCustomer()));
            session.setAttribute("seeUserName", cus.getUserName());
            session.setAttribute("seeRole", cus.getRole());
            session.setAttribute("seeUser", cus);
            if (cus.getRole().equals("ADMIN")) {
                response.sendRedirect(request.getContextPath() + "/list-dish");
            } else {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        } else {
            request.setAttribute("errorMsg", "Authentication Failed!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
