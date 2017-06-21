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
    public Product getProduct(int id) {
        boolean flag = true;
        int i = 0;
        Product p = new Product();
        while (flag) {
            p = products.get(i);
            if (p.getId() == id) flag = false;
        }
        return p;
    }

    @Override
    public Integer createProduct(Product product) {
        product.setId(++ID);
        products.add(product);
        return product.getId();
    }

    @Override
    public void updateProduct(Product product, Integer id) {
        deleteProduct(id);
        products.add(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        boolean flag = true;
        int i = 0;
        Product p;
        while (flag) {
            p = products.get(i);
            if (p.getId() == id) {
                flag = false;
                products.remove(i);
            }
        }
    }

    @Override
    public ArrayList<State> getStatesOfProductByDate(int id, String state, Date startDate, Date endDate) {
        ArrayList<State> states = new ArrayList<> ();
        Product p = getProduct(id);
        ArrayList<Historical> historical = p.getHistorical();
        for(int i=0; i<historical.size(); i++){
            Date dateChanged = historical.get(i).getDateChanged();
            if(dateChanged.after(startDate) && dateChanged.before(endDate)){
                if(state.equalsIgnoreCase(historical.get(i).getState().toString())) {
                    states.add(historical.get(i).getState());
                }
            }
        }
        return states;
    }
}
