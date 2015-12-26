package org.hardcrystal.food.dao;

import org.hardcrystal.food.model.Dishes;

import java.util.List;

/**
 * Created by Administrator on 18.12.2015.
 */
public interface DishDAO {
    public void addRecipe( Dishes recipe );
    public void delRecipe( int id_dish );
    public void updRecipe( Dishes recipe );
    public List<Dishes> getAllDishes();
    public Dishes getDishesById( int id_dish );
}
