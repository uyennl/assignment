/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.utils;

/**
 *
 * @author PC
 */
public class MyQuery {

    //Category
    public static final String SELECT_ALL_CATEGORIES = "SELECT * FROM category;";

    public static final String SELECT_CATEGORY_BY_ID = "SELECT * FROM category WHERE idCategory = ?;";

    public static final String DELETE_CATEGORY_BY_ID = "DELETE FROM category WHERE idCategory = ?;";

    public static final String SELECT_CATEGORY_BY_NAME = "SELECT * FROM category WHERE cateName = ?;";

    public static final String ADD_CATEGORY = "INSERT INTO category (cateName) VALUES (?);";

    public static final String UPDATE_CATEGORY = "UPDATE category SET cateName = ? WHERE idCategory = ?;";

//Dish
    public static final String SELECT_ALL_DISHES = "SELECT * FROM dish;";

    public static final String SELECT_DISH_BY_ID = "SELECT * FROM dish WHERE idDish = ?;";

    public static final String SELECT_DISH_BY_NAME = "select * from dish where title like ?;";

    public static final String DELETE_DISH_BY_ID = "DELETE FROM dish WHERE idDish = ?;";

    public static final String ADD_DISH = "INSERT INTO dish (title, subTitle, price, image,status,idCategory) "
            + "VALUES (?, ?, ?, ?, ?, ?);";

    public static final String UPDATE_DISH = "UPDATE dish "
            + "SET title = ?, subTitle = ?, price = ?, image = ?, status = ? ,idCategory = ?"
            + "WHERE idDish = ?;";

// Customer
    public static final String ADD_CUSTOMER = "insert into customer (userName, passWord, firstName, lastName, avatar, phoneNumber, dateOfBirth, role)"
            + " values (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String SELECT_ALL_CUSTOMERS = "select * from customer;";

// Account
    public static final String CHECK_LOGIN = "select * from customer where userName = ? and passWord = ?;";
// Order
    public static final String ORDER_DISH = "";
}
