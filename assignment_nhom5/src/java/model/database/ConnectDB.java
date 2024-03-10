/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database;

/**
 *
 * @author PC
 */
import java.sql.*;

/**
 *
 * @author longle2507
 */
public class ConnectDB implements BaseConnection{
    private static ConnectDB instance;
    
    public static ConnectDB getInstance(){
        if(instance == null){
            instance = new ConnectDB();
        }
        
        return instance;
    }
    
     public static Connection openConnection() throws Exception{
        Class.forName(DRIVER_NAME);  
        Connection con = DriverManager.getConnection(URL,USER_NAME,PASS_WORD);
        
        return con;
    }
       
       
       
        
      
    
    public static void closeConnection(Connection con,PreparedStatement pst) throws SQLException{
        try{
            if(con != null){ 
                con.close();
            }
            pst.close();
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    
     
        public static void closeConnection(Connection con,PreparedStatement pst,ResultSet rs) throws SQLException{
        try{
            con.close();
            pst.close();
            rs.close();
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

}
