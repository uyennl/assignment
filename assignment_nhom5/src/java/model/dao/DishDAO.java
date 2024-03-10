package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.database.ConnectDB;
import model.entity.Category;
import model.entity.Dish;
import model.utils.MyQuery;

public class DishDAO implements DAOInterface<Dish> {

    @Override
    public ArrayList<Dish> selectAll() {
        ArrayList<Dish> dishList = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Connection con = db.openConnection();
            preparedStatement = con.prepareStatement(MyQuery.SELECT_ALL_DISHES);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idDish = resultSet.getInt("idDish");
                String title = resultSet.getString("title");
                String subTitle = resultSet.getString("subTitle");
                float price = resultSet.getFloat("price");
                String image = resultSet.getString("image"); // Lấy dữ liệu ảnh từ cơ sở dữ liệu
                boolean status = resultSet.getBoolean("status"); // Thêm trạng thái từ cơ sở dữ liệu
                int idcate = resultSet.getInt("idCategory");
                Category category = (new CategoryDAO().selectByID(idcate));
                Dish dish = new Dish(idDish, title, subTitle, price, image, status, category);
                dishList.add(dish);
                System.out.println(dish);
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return dishList;
    }

    @Override
    public Dish selectByID(int idDish) {
        Dish dish = null;
        ConnectDB db = ConnectDB.getInstance();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Connection con = db.openConnection();
            preparedStatement = con.prepareStatement(MyQuery.SELECT_DISH_BY_ID);
            preparedStatement.setInt(1, idDish);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String subTitle = resultSet.getString("subTitle");
                float price = resultSet.getFloat("price");
                String image = resultSet.getString("image"); // Lấy dữ liệu ảnh từ cơ sở dữ liệu
                boolean status = resultSet.getBoolean("status"); // Thêm trạng thái từ cơ sở dữ liệu
                int idcate = resultSet.getInt("idCategory");
                Category category = (new CategoryDAO().selectByID(idcate));
                dish = new Dish(idDish, title, subTitle, price, image, status, category);
                System.out.println(dish);
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return dish;
    }

    @Override
    public void delete(int idDish) {
        ConnectDB db = ConnectDB.getInstance();

        try {
            Connection con = db.openConnection();
            PreparedStatement pst = con.prepareStatement(MyQuery.DELETE_DISH_BY_ID);
            pst.setInt(1, idDish);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void insert(Dish t) {
        ConnectDB db = ConnectDB.getInstance();
        try {
            Connection con = db.openConnection();
            PreparedStatement pst = con.prepareStatement(MyQuery.ADD_DISH);
            pst.setString(1, t.getTitle());
            pst.setString(2, t.getSubTitle());
            pst.setFloat(3, t.getPrice());
            pst.setString(4, t.getImage()); // Thêm dữ liệu ảnh vào câu lệnh SQL
            pst.setBoolean(5, t.isStatus()); // Thêm trạng thái vào câu lệnh SQL
            pst.setInt(6, t.getCategory().getIdCategory());
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void insertAll(ArrayList<Dish> arr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll(Dish t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Dish t) {
        ConnectDB db = ConnectDB.getInstance();
        try {
            Connection con = db.openConnection();
            PreparedStatement pst = con.prepareStatement(MyQuery.UPDATE_DISH);
            pst.setString(1, t.getTitle());
            pst.setString(2, t.getSubTitle());
            pst.setFloat(3, t.getPrice());
            pst.setString(4, t.getImage());
            pst.setBoolean(5, t.isStatus());
            pst.setInt(6, t.getCategory().getIdCategory());
            pst.setInt(7, t.getIdDish());
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Dish> selectByName(String nameDish) {
        ConnectDB db = ConnectDB.getInstance();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Dish> disList = new ArrayList<>();
        try {
            Connection con = db.openConnection();
            preparedStatement = con.prepareStatement(MyQuery.SELECT_DISH_BY_NAME);
            preparedStatement.setString(1, "%" + nameDish + "%");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idDish = resultSet.getInt("idDish");
                String title = resultSet.getString("title");
                String subTitle = resultSet.getString("subTitle");
                float price = resultSet.getFloat("price");
                String image = resultSet.getString("image"); // Lấy dữ liệu ảnh từ cơ sở dữ liệu
                boolean status = resultSet.getBoolean("status"); // Thêm trạng thái từ cơ sở dữ liệu
                int idcate = resultSet.getInt("idCategory");
                Category category = (new CategoryDAO().selectByID(idcate));
                disList.add(new Dish(idDish, title, subTitle, price, image, status, category));
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return disList;
    }

    public static void main(String[] args) {
        DishDAO disDAO = new DishDAO();
        ArrayList<Dish> disList = disDAO.selectByName("c");
        for(int i = 0; i < disList.size(); i++){
            System.out.println(disList.toString());
        }
    }
}
