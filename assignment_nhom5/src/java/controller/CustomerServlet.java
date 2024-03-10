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
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.dao.CustomerDAO;
import model.entity.Customer;

/**
 *
 * @author PC
 */
public class CustomerServlet extends HttpServlet {

    private CustomerDAO customerDAO = new CustomerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        System.out.println(url);
        switch (url) {
            case "/admin-list":
                showList(request, response);
                break;
            case "/add-infor":
                showAdd(request, response);
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
            case "/add-infor":
                addCustomer(request, response);
                break;
            default:
                break;
        }
    }
    
    private void showAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addCustomer.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Customer> cusList = customerDAO.selectAll();
        request.setAttribute("cusList", cusList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listCustomer.jsp");
        dispatcher.forward(request, response);   
    }
    
    private void addCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hello");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String avatar = request.getParameter("avatar");
        String phoneNumber = request.getParameter("phoneNumber");
        String sDate1 = request.getParameter("dateOfBirth");
        Date dateOfBirth = new Date();
        try{
            dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        }catch(Exception e){
            System.out.println(e);
        }
        String role = "USER";
        Customer cus = new Customer(userName, passWord, firstName, lastName, avatar, phoneNumber, dateOfBirth, role);
        customerDAO.insert(cus);
    }

}
