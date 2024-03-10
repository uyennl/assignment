/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.database.ConnectDB;
import model.entity.Category;
import model.utils.MyQuery;

public class CategoryDAO implements DAOInterface<Category> {

    @Override
    public ArrayList<Category> selectAll() {
        ArrayList<Category> categoryList = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();

        try {
            Connection con = db.openConnection();
            PreparedStatement preparedStatement = con.prepareStatement(MyQuery.SELECT_ALL_CATEGORIES);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idCategory = resultSet.getInt("idCategory");
                String nameCategory = resultSet.getString("cateName");
                Category category = new Category(idCategory, nameCategory);
                categoryList.add(category);
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return categoryList;
    }

    @Override
    public Category selectByID(int idCategory) {
        Category category = null;
        ConnectDB db = ConnectDB.getInstance();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Connection con = db.openConnection();
            preparedStatement = con.prepareStatement(MyQuery.SELECT_CATEGORY_BY_ID);
            preparedStatement.setInt(1, idCategory);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nameCategory = resultSet.getString("cateName");
                category = new Category(idCategory, nameCategory);
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return category;
    }
    public ArrayList<Category> selectByName(String nameCate) {
        ArrayList<Category> cateList = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Connection con = db.openConnection();
            preparedStatement = con.prepareStatement(MyQuery.SELECT_CATEGORY_BY_NAME);
            preparedStatement.setString(1, nameCate);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idCate = resultSet.getInt("idCategory");
                Category category = new Category(idCate, nameCate);
                cateList.add(category);
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return cateList;
    }
    @Override
    public void delete(int idCategory) {
        ConnectDB db = ConnectDB.getInstance();
        PreparedStatement preparedStatement = null;

        try {
            Connection con = db.openConnection();
            preparedStatement = con.prepareStatement(MyQuery.DELETE_CATEGORY_BY_ID);
            preparedStatement.setInt(1, idCategory);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void insert(Category t) {
        ConnectDB db = ConnectDB.getInstance();
        try {
            Connection con = db.openConnection();
            PreparedStatement pst = con.prepareStatement(MyQuery.ADD_CATEGORY);
            pst.setString(1, t.getNameCategory());
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void insertAll(ArrayList<Category> arr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll(Category t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update( Category t) {
        ConnectDB db = ConnectDB.getInstance();
        try {
            Connection con = db.openConnection();
            PreparedStatement pst = con.prepareStatement(MyQuery.UPDATE_CATEGORY);
            pst.setString(1, t.getNameCategory());
            pst.setInt(2, t.getIdCategory());
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public static void main(String[] args) {
        CategoryDAO cateDAO = new CategoryDAO();
        ArrayList<Category> cateList  = cateDAO.selectAll();
        for(int i = 0; i < cateList.size(); i++){
            System.out.println(cateList.toString());
        }
    }
}

