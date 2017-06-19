package com.stock.app.model;

import java.util.ArrayList;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by juan_ on 12/06/2017.
 */
public class Product {
    
    private int id;
    
    private int productCode;
    
    @NotNull
    @Size(min = 5, max = 20, message = "The length of name must be between 5 to 20")
    private String productName;
    
    @NotNull
    private String productOrigin;
    private int stock;
    
    @NotNull
    private ProductType productType;
    
    @NotNull
    private ArrayList<Historical> historical;    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductOrigin() {
        return productOrigin;
    }

    public void setProductOrigin(String productOrigin) {
        this.productOrigin = productOrigin;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ArrayList<Historical> getHistorical() {
        return historical;
    }

    public void setHistorical(ArrayList<Historical> historical) {
        this.historical = historical;
    }    
}
