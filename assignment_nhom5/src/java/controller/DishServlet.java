package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.DishDAO;
import model.entity.Dish;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.dao.CategoryDAO;
import model.entity.Category;

public class DishServlet extends HttpServlet {

    private DishDAO dishDAO = new DishDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getServletPath();
        System.out.println(url);
        switch (url) {
            case "/list-dish":
                showAll(request, response);
                break;
            case "/add-dish":
                showAdd(request, response);
                break;
            case "/edit-dish":
                showEdit(request, response);
                break;
            case "/delete-dish":
                deleteDish(request, response);
                break;
            case "/search-dish-by-name":
                searchDishByName(request, response);
                break;
            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getServletPath();
        System.out.println(url);
        switch (url) {
            case "/add-dish":
                addDish(request, response);
                break;
            case "/edit-dish":
                updateDish(request, response);
                break;
            case "/search-dish-by-name":
                searchDishByName(request, response);
                break;
            default:
                break;
        }
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dish> dishList = dishDAO.selectAll();
        request.setAttribute("dishList", dishList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listDish.jsp");
        dispatcher.forward(request, response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> cateList = categoryDAO.selectAll();
        for (Category category : cateList) {
            System.out.println(category);
        }
        int idDish = Integer.parseInt(request.getParameter("idDish"));
        Dish dish = dishDAO.selectByID(idDish);
        request.setAttribute("cateList", cateList);
        request.setAttribute("dish", dish);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editDish.jsp");
        dispatcher.forward(request, response);
    }

    private void showAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Category> cate_list = categoryDAO.selectAll();
        for (Category category : cate_list) {
            System.out.println(category);
        }
        request.setAttribute("cate_list", cate_list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addDish.jsp");
        dispatcher.forward(request, response);
    }

    private void addDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String subTitle = request.getParameter("subTitle");
        float price = Float.parseFloat(request.getParameter("price"));
        String image = request.getParameter("imageDish");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        int idCate = Integer.parseInt(request.getParameter("category"));
        Category category = (new CategoryDAO().selectByID(idCate));
        Dish dish = new Dish(title, subTitle, price, image, status, category);
        dishDAO.insert(dish);
        showAll(request, response);
    }

    private void updateDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDish = Integer.parseInt(request.getParameter("idDish"));
        String title = request.getParameter("title");
        String subTitle = request.getParameter("subTitle");
        float price = Float.parseFloat(request.getParameter("price"));
        String image = request.getParameter("image");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        int idCate = Integer.parseInt(request.getParameter("category"));
        Category category = (new CategoryDAO().selectByID(idCate));
        Dish dish = new Dish(idDish, title, subTitle, price, image, status, category);
        dishDAO.update(dish);
        showAll(request, response);
    }

    private void deleteDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDish = Integer.parseInt(request.getParameter("idDish"));
        dishDAO.delete(idDish);
        response.sendRedirect("list-dish");
    }

    private void searchDishByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameDish = request.getParameter("nameDish");
        ArrayList<Dish> dishList = dishDAO.selectByName(nameDish);
        request.setAttribute("dishList", dishList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listDish.jsp");
        dispatcher.forward(request, response);
    }
}
