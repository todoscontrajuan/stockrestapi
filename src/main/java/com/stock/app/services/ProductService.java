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
    Integer createProduct(Product product);
    
    ArrayList<State> getStateOfProductByDate(int id, Date startDate, Date endDate);
    
}
