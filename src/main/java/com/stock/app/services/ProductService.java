package com.stock.app.services;

import com.stock.app.model.Product;

import java.util.ArrayList;

/**
 * Created by juan_ on 12/06/2017.
 */
public interface ProductService {

    ArrayList<Product> getProducts();
    Integer createProduct(Product product);
}
