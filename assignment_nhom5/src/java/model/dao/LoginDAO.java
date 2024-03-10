/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.database.ConnectDB;
import model.entity.Customer;
import java.sql.*;
import model.utils.MyQuery;

/**
 *
 * @author PC
 */
public class LoginDAO {

    private ConnectDB db = null;

    public Customer checkLogin(String userName, String passWord) {
        db = ConnectDB.getInstance();
        Customer cus = null;
        try {
            Connection conn = db.openConnection();
            PreparedStatement pst = conn.prepareStatement(MyQuery.CHECK_LOGIN);
            pst.setString(1, userName);
            pst.setString(2, passWord);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idCustomer");
                String role = rs.getString("role");
                cus = new Customer(id,userName,passWord,role); 
            }
            pst.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return cus;
    }
}
