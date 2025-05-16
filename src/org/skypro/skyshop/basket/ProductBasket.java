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
        return products.values().stream()
                .flatMap(List::stream)       // "Разворачиваем" List<Product> в Stream<Product>
                .mapToInt(Product::getPriceProduct) // Преобразуем в IntStream
                .sum();                      // Суммируем
    }

    public boolean containsProductByName(String name) {
        return products.containsKey(name);
    }

    public void clearBasket() {
        products.clear();
    }

    public void printBasket() {
        products.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println); // Печатаем все продукты

        System.out.println("Special products: " + getSpecialCount());
    }

    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = products.remove(name);
        if (removedProducts == null) {
            return new ArrayList<>();
        }
        return removedProducts;
    }
}
