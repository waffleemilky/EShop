package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        String name = product.getNameProduct();
        if (products.containsKey(name)) {
            products.get(name).add(product);
        } else {
            List<Product> productList = new ArrayList<>();
            productList.add(product);
            products.put(name, productList);
        }
    }

    public int getSumBasket() {
        int sum = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                sum += product.getPriceProduct();
            }
        }
        return sum;
    }

    public boolean containsProductByName(String name) {
        return products.containsKey(name);
    }

    public void clearBasket() {
        products.clear();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            System.out.println("Содержимое корзины:");
            for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
                String name = entry.getKey();
                List<Product> productList = entry.getValue();
                for (Product product : productList) {
                    System.out.println("- " + product.toString());
                }
            }
        }
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = products.remove(name);
        if (removedProducts == null) {
            return new ArrayList<>(); // Возвращаем пустой список, если продукта нет
        }
        return removedProducts;
    }
}
