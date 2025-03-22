package org.skypro.skyshop.product;

public abstract class Product {
    private final String nameProduct;

    public Product(String name) {
        this.nameProduct = name;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract int getPriceProduct();

    public abstract boolean isSpecial();
}
