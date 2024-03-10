/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.database;

/**
 *
 * @author PC
 */
public interface BaseConnection {
    public static String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String URL = "jdbc:sqlserver://LAPTOP-EM5PH2CG\\NEYU:1433;databaseName=pizza_store;encrypt=true;trustServerCertificate=true;";
    public static String USER_NAME = "sa";
    public static String PASS_WORD = "123456";
}
