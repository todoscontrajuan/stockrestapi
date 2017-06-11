package com.stock.app.model;


public class PatchOperation {

    private String op;
    private String path;
    private String value;

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

/**
{
  "op":"replace",
  "path":"name",
  "value":"agustina"
 }
 **/