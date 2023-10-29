package org.example.Classes;

public class Item {
    private String name;
    private String descripton;
    private int stock;

    public Item(String name, String descripton, int stock) {
        this.name = name;
        this.descripton = descripton;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
