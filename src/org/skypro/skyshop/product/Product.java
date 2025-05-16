package org.skypro.skyshop.product;

import org.skypro.skyshop.info.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String nameProduct;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой или null.");
        }
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameProduct);
    }
}
