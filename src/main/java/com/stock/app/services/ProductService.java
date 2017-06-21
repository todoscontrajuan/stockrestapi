package com.stock.app.services;

import com.stock.app.model.Product;
import com.stock.app.model.State;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by juan_ on 12/06/2017.
 */
public interface ProductService {

    ArrayList<Product> getProducts();
    Product getProduct(int id);
    Integer createProduct(Product product);
    void updateProduct(Product product, Integer id);
    void deleteProduct(Integer id);
    ArrayList<State> getStatesOfProductByDate(int id, String state, Date startDate, Date endDate);
    
}
