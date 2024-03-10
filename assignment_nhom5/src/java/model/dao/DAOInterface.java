/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface DAOInterface<T> {

    public ArrayList<T> selectAll();

    public T selectByID(int t);

    public void insert(T t);

    public void insertAll(ArrayList<T> arr);

    public void delete(int t);

    public void deleteAll(T t);

    public void update(T tt);
    
    public ArrayList<T> selectByName(String t);

}
