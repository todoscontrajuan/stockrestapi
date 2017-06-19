package com.stock.app.services;

import com.stock.app.model.Historical;
import com.stock.app.model.Product;
import com.stock.app.model.State;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by juan_ on 12/06/2017.
 */
public class ProductServiceImpl implements ProductService{

    private static ArrayList<Product> products = new ArrayList<>();
    private static Integer ID = 0;

    @Override
    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public Integer createProduct(Product product) {
        product.setId(++ID);
        products.add(product);
        return product.getId();
    }

    @Override
    public ArrayList<State> getStateOfProductByDate(int id, Date startDate, Date endDate) {
      
        ArrayList<State> states = new ArrayList<> ();
        //TO DO USED THE PRODUCT'S ID
        Product p = new Product();
        
        ArrayList<Historical> historical = p.getHistorical();
        for(int i=0; i<=historical.size()-1; i++){            
            Date dateChanged = historical.get(i).getDateChanged();                
            if(dateChanged.after(startDate) && dateChanged.before(endDate)){
                states.add(historical.get(i).getState());
            }
        }
        return states;
    }
}
