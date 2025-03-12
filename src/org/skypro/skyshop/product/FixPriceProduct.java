package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final int FIXPRICE = 25;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPriceProduct() {
        return FIXPRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getNameProduct() + ": Фиксированная цена " + FIXPRICE;
    }
}
