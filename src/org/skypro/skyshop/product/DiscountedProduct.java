package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int basePrice;
    private final int discount;
    private final int discountPrice;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
        this.discountPrice = calculateDiscountedPrice();
    }

    private int calculateDiscountedPrice() {
        double discountAmount = (double) basePrice * discount / 100;
        return (int) (basePrice - discountAmount);
    }

    @Override
    public int getPriceProduct() {
        return discountPrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getNameProduct() + ": " + getPriceProduct() + " (" + discount + "%)";
    }
}
