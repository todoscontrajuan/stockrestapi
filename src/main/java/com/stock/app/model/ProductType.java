package com.stock.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by juan_ on 12/06/2017.
 */
public class ProductType {
    
    private int idProductType;
    
    @NotNull
    @Size(min = 1, max = 10, 
         message = "The length of the productTypeName must be between 1 to 10")
    private String productTypeName;

    public int getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(int idProductType) {
        this.idProductType = idProductType;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
    
    
    
    
}
