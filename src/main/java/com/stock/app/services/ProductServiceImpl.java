package com.stock.app.services;

import com.stock.app.model.Product;

import java.util.ArrayList;

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
}
