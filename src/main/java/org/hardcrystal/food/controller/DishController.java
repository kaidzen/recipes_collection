package org.hardcrystal.food.controller;

import org.hardcrystal.food.dao.DishDAO;
import org.hardcrystal.food.dao.DishDaoImpl;
import org.hardcrystal.food.model.Dishes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 18.12.2015.
 */
@WebServlet(name = "DishController", urlPatterns = { "/DishController", "/dishes" })
public class DishController extends HttpServlet {

    private DishDAO dishDao;
    public static final String LIST = "/listDishes.jsp";
    public static final String INSERT_OR_EDIT = "/dish.jsp";

    public DishController() {
        dishDao = new DishDaoImpl();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forwardPath = "";
        String action = request.getParameter( "action" );

        if( "delete".equalsIgnoreCase(action) ) {
            forwardPath = LIST;
            int id_dish = Integer.parseInt( request.getParameter("id_dish") );
            dishDao.delRecipe(id_dish);
            request.setAttribute("dishes", dishDao.getAllDishes() );
        }
        else if( "edit".equalsIgnoreCase(action) ) {
            forwardPath = INSERT_OR_EDIT;
            int dishId = Integer.parseInt( request.getParameter("id_dish") );
            Dishes dish = dishDao.getDishesById(dishId);
            request.setAttribute("dishes", dish);
        }
        else if( "insert".equalsIgnoreCase(action) ) {
            forwardPath = INSERT_OR_EDIT;
        }
        else {
            forwardPath = LIST;
            request.setAttribute("dishes", dishDao.getAllDishes());
        }
        RequestDispatcher view = request.getRequestDispatcher( forwardPath );
        view.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Dishes dish = new Dishes();
        dish.setId_dish(Integer.parseInt(request.getParameter("id_dish")));
        dish.setName(request.getParameter("name"));
        dish.setCalories(Integer.parseInt(request.getParameter("calories")));
        dish.setList(request.getParameter("list"));
        dish.setProcess(request.getParameter("process"));

        Integer dishId = Integer.parseInt(request.getParameter("id_dish"));

        if( dishId == null  )
            dishDao.addRecipe(dish);
        else {
            dish.setId_dish(Integer.valueOf(dishId));
            dishDao.updRecipe(dish);
        }
        RequestDispatcher view = request.getRequestDispatcher( LIST );
        request.setAttribute("dishes", dishDao.getAllDishes());
        view.forward(request, response);

    }
}
