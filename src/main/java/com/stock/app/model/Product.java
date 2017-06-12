package com.stock.app.model;

/**
 * Created by juan_ on 12/06/2017.
 */
public class Product {
    private int productCode;
    private String productName;
    private String productOrigin;
    private int stock;
    private ProctType productType;
    private int id;

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

    public ProctType getProductType() {
        return productType;
    }

    public void setProductType(ProctType productType) {
        this.productType = productType;
    }
}
