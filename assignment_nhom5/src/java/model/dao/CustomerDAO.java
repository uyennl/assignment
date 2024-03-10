/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.ArrayList;
import model.database.ConnectDB;
import model.entity.Customer;
import java.sql.*;
import model.utils.MyQuery;

/**
 *
 * @author PC
 */
public class CustomerDAO implements DAOInterface<Customer> {

    private ConnectDB db = null;

    @Override
    public ArrayList<Customer> selectAll() {
        ArrayList<Customer> cusList = new ArrayList<>();
        db = ConnectDB.getInstance();
        try {
            Connection con = db.openConnection();
            PreparedStatement pst = con.prepareStatement(MyQuery.SELECT_ALL_CUSTOMERS);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setIdCustomer(rs.getInt("idCustomer"));
                customer.setUserName(rs.getString("userName"));
                customer.setPassWord(rs.getString("passWord"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setAvatar(rs.getString("avatar"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setDateOfBirth(rs.getDate("dateOfBirth"));
                customer.setRole(rs.getString("role"));
                cusList.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cusList;
    }

    @Override
    public Customer selectByID(int t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Add Customer method
    @Override
    public void insert(Customer customer) {
        db = ConnectDB.getInstance();
        try (
             Connection con = db.openConnection(); PreparedStatement pst = con.prepareStatement(MyQuery.ADD_CUSTOMER)) {
            pst.setString(1, customer.getUserName());
            pst.setString(2, customer.getPassWord());
            pst.setString(3, customer.getFirstName());
            pst.setString(4, customer.getLastName());
            pst.setString(5, customer.getAvatar());
            pst.setString(6, customer.getPhoneNumber());
            java.util.Date utilDate = customer.getDateOfBirth();
            java.sql.Date dateOfBirth = new java.sql.Date(utilDate.getTime());
            pst.setDate(7, dateOfBirth);
            pst.setString(8, customer.getRole());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void insertAll(ArrayList<Customer> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAll(Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Customer tt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Customer> selectByName(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        CustomerDAO cusDAO = new CustomerDAO();
        cusDAO.insert(new Customer("long123","123","Long","Le","https://images.unsplash.com/photo-1635805737707-575885ab0820?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D","0587107407",Date.valueOf("2003-07-25"),"ADMIN"));
        ArrayList<Customer> cuList = cusDAO.selectAll();
        for(int i = 0; i < cuList.size(); i++){
            System.out.println(cuList.toString());
        }
        
    }

}
