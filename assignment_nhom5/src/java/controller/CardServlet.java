///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package controller;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import model.entity.Dish;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class CardServlet extends HttpServlet {
//
//    private static final String CART_COOKIE_NAME = "cart_items";
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//
//        switch (action) {
//            case "add-to-card":
//                addToCart(request, response);
//                break;
//            case "view-card":
//                viewCart(request, response);
//                break;
//            case "delete-from-card":
//                removeFromCart(request, response);
//                break;
//            case "clear-card":
//                clearCart(request, response);
//                break;
//            case "checkout-card":
//                checkout(request, response);
//                break;
//            default:
//                break;
//        }
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         String url = request.getServletPath();
//        switch (url) {
//            case "/add-to-card":
//                addToCart(request, response);
//                break;
//            default:
//                break;
//        }
//
//    }
//
//    private void addToCart(HttpServletRequest request, HttpServletResponse response) {
//        List<Dish> cartItems = getCartItems(request);
//        int idDish = Integer.parseInt(request.getParameter("idDish"));
//        String title = request.getParameter("title");
//        String subTitle = request.getParameter("subTitle");
//        float price = Float.parseFloat(request.getParameter("price"));
//        String image = request.getParameter("image"); // Lấy dữ liệu hình ảnh từ request
//
//        Dish dish = new Dish(idDish, title, subTitle, price, image);
//        cartItems.add(dish);
//        saveCartToCookies(response, cartItems);
//    }
//
//    private List<Dish> getCartItems(HttpServletRequest request) {
//        List<Dish> cartItems = new ArrayList<>();
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals(CART_COOKIE_NAME)) {
//                    String[] itemIds = cookie.getValue().split(",");
//                    for (String itemId : itemIds) {
//                        // Retrieve dish information based on item ID from your database or storage
//                        // Then add it to the cartItems list
//                        // For demonstration, I'll just create a dummy dish object
//                        int idDish = Integer.parseInt(itemId);
//                        String title = "Dummy Dish"; // Retrieve from database
//                        String subTitle = "Dummy Subtitle"; // Retrieve from database
//                        float price = 0.0f; // Retrieve from database
//                        String image = "dummy_image.jpg"; // Retrieve from database
//                        Dish dish = new Dish(idDish, title, subTitle, price, image);
//                        cartItems.add(dish);
//                    }
//                    break;
//                }
//            }
//        }
//        return cartItems;
//    }
//
//    private void saveCartToCookies(HttpServletResponse response, List<Dish> cartItems) {
//        StringBuilder cartContent = new StringBuilder();
//        for (Dish dish : cartItems) {
//            cartContent.append(dish.getIdDish()).append(",");
//        }
//        Cookie cartCookie = new Cookie(CART_COOKIE_NAME, cartContent.toString());
//        response.addCookie(cartCookie);
//    }
//
//    private void viewCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Dish> cartItems = getCartItems(request);
//        request.setAttribute("cartItems", cartItems);
//        request.getRequestDispatcher("cart.jsp").forward(request, response);
//    }
//
//    private void removeFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int idDishToRemove = Integer.parseInt(request.getParameter("idDish"));
//        List<Dish> cartItems = getCartItems(request);
//        Optional<Dish> itemToRemove = cartItems.stream().filter(item -> item.getIdDish() == idDishToRemove).findFirst();
//        itemToRemove.ifPresent(cartItems::remove);
//        saveCartToCookies(response, cartItems);
//        viewCart(request, response);
//    }
//
//    private void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Cookie cartCookie = new Cookie(CART_COOKIE_NAME, "");
//        cartCookie.setMaxAge(0);
//        response.addCookie(cartCookie);
//        viewCart(request, response);
//    }
//
//    private void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Logic for checkout goes here
//        // This method can be used to process payment, clear the cart, etc.
//        // For demonstration, let's just clear the cart
//        clearCart(request, response);
//    }
//}
