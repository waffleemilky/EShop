package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int productCount = 0;

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getSumBasket() {
        int sum = 0;
        for (int i = 0; i < productCount; i++) {
            sum += products[i].getPriceProduct();
        }
        return sum;
    }

    public void printBasket() {
        if (productCount == 0) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialProductCount = 0;

        for (int i = 0; i < productCount; i++) {
            Product product = products[i];
            System.out.println(product.toString());
            if (product.isSpecial()) {
                specialProductCount++;
            }
        }

        System.out.println("Итого: " + getSumBasket());
        System.out.println("Специальных товаров: " + specialProductCount);
    }

    public boolean containsProductByName(String productName) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getNameProduct().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(products, null);
        productCount = 0;
    }
}
