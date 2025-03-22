package org.skypro.skyshop.product;

import org.skypro.skyshop.info.Searchable;

public abstract class Product implements Searchable {
    private final String nameProduct;

    public Product(String name) {
        this.nameProduct = name;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract int getPriceProduct();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return getNameProduct();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return getNameProduct();
    }

}
