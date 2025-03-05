package org.skypro.skyshop.product;

public class Product {
    private final String nameProduct;
    private final int priceProduct;

    public Product(String name, int price) {
        this.nameProduct = name;
        this.priceProduct = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }
}
