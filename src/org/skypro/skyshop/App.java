package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        Product apple = new Product("Яблоко", 50);
        Product milk = new Product("Молоко", 100);
        Product bread = new Product("Хлеб", 75);
        Product banana = new Product("Банан", 60);
        Product orange = new Product("Апельсин", 80);
        Product grape = new Product("Виноград", 120);

        System.out.println("\n1. Добавление продукта в корзину:");
        basket.addProduct(apple);
        basket.addProduct(milk);
        basket.addProduct(bread);

        System.out.println("\n2. Добавление продукта в заполненную корзину:");
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(grape); // Попытка добавить шестой продукт

        System.out.println("\n3. Печать содержимого корзины с несколькими товарами:");
        basket.printBasket();

        System.out.println("\n4. Получение стоимости корзины с несколькими товарами:");
        System.out.println("Стоимость корзины: " + basket.getSumBasket());

        System.out.println("\n5. Поиск товара, который есть в корзине:");
        String productName = "Молоко";
        if (basket.containsProductByName(productName)) {
            System.out.println("Товар '" + productName + "' найден в корзине.");
        } else {
            System.out.println("Товар '" + productName + "' не найден в корзине.");
        }

        System.out.println("\n6. Поиск товара, которого нет в корзине:");
        productName = "Виноград";
        if (basket.containsProductByName(productName)) {
            System.out.println("Товар '" + productName + "' найден в корзине.");
        } else {
            System.out.println("Товар '" + productName + "' не найден в корзине.");
        }

        System.out.println("\n7. Очистка корзины:");
        basket.clearBasket();
        System.out.println("Корзина очищена.");

        System.out.println("\n8. Печать содержимого пустой корзины:");
        basket.printBasket();

        System.out.println("\n9. Получение стоимости пустой корзины:");
        System.out.println("Стоимость корзины: " + basket.getSumBasket());

        System.out.println("\n10. Поиск товара по имени в пустой корзине:");
        productName = "Яблоко";
        if (basket.containsProductByName(productName)) {
            System.out.println("Товар '" + productName + "' найден в корзине.");
        } else {
            System.out.println("Товар '" + productName + "' не найден в корзине.");
        }

    }
}