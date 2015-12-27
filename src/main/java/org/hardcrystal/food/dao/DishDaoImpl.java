package org.hardcrystal.food.dao;

import org.hardcrystal.food.dbHelpers.dbInfo;
import org.hardcrystal.food.model.Dishes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 18.12.2015.
 */
public class DishDaoImpl implements DishDAO {

    private final Connection conn;

    public DishDaoImpl() {
        conn = dbInfo.getConnection();
    }

    @Override
    public void addRecipe(Dishes recipe) {

        try {
            String query = "insert into dishes (name, calories, list, process) values (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            // preparedStatement.setInt( 1, recipe.getId_dish() );
            preparedStatement.setString(1, recipe.getName());
            preparedStatement.setInt(2, recipe.getCalories());
            preparedStatement.setString(3, recipe.getList());
            preparedStatement.setString(4, recipe.getProcess());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delRecipe(int id_dish) {

    }

    @Override
    public void updRecipe(Dishes recipe) {

    }

    @Override
    public List<Dishes> getAllDishes() {

        List<Dishes> dishes = new ArrayList<Dishes>();

        try {
            Statement statement = conn.createStatement();
            String query = "select * from dishes";
            ResultSet resultSet = statement.executeQuery(query);
            while ( resultSet.next() ){
                Dishes dish = new Dishes();
                dish.setId_dish(resultSet.getInt("id_dish"));
                dish.setName(resultSet.getString("name"));
                dish.setCalories(resultSet.getInt("calories"));
                dish.setList(resultSet.getString("list"));
                dish.setProcess(resultSet.getString("process"));
                dishes.add(dish);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dishes;
    }

    @Override
    public Dishes getDishesById(int id_dish) {
        return null;
    }

}
