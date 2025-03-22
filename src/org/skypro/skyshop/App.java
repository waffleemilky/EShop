package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.info.Article;
import org.skypro.skyshop.info.SearchEngine;
import org.skypro.skyshop.info.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    private static void printSearchResults(Searchable[] results) {
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            } else {
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        Product apple = new SimpleProduct("Яблоко", 50);
        Product milk = new DiscountedProduct("Молоко", 100, 15);
        Product bread = new FixPriceProduct("Хлеб");
        Product banana = new DiscountedProduct("Банан", 60, 20);
        Product orange = new SimpleProduct("Апельсин", 80);
        Product grape = new SimpleProduct("Виноград", 120);

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

        System.out.println("\n11. Поисковой Движок");
        SearchEngine searchEngine = new SearchEngine(8);

        Article appleArticle = new Article("Яблоки: польза и вред", "В этой статье мы расскажем о пользе и вреде яблок.");
        Article milkArticle = new Article("Как выбрать молоко", "Советы по выбору качественного молока.");
        Article bakingArticle = new Article("Рецепт домашнего хлеба", "Простой рецепт вкусного домашнего хлеба.");

        searchEngine.add(apple);
        searchEngine.add(milk);
        searchEngine.add(bread);
        searchEngine.add(banana);
        searchEngine.add(orange);

        searchEngine.add(appleArticle);
        searchEngine.add(milkArticle);
        searchEngine.add(bakingArticle);

        System.out.println("--- Поиск по запросу 'Яблоко' ---");
        Searchable[] results1 = searchEngine.search("Яблоко");
        printSearchResults(results1);

        System.out.println("\n--- Поиск по запросу 'Молоко' ---");
        Searchable[] results2 = searchEngine.search("Молоко");
        printSearchResults(results2);

        System.out.println("\n--- Поиск по запросу 'Хлеб' ---");
        Searchable[] results3 = searchEngine.search("Хлеб");
        printSearchResults(results3);

        System.out.println("\n--- Поиск по запросу 'Статья' (не найдет ничего, т.к. ищем по термину поиска)---");
        Searchable[] results4 = searchEngine.search("Статья");
        printSearchResults(results4);

        System.out.println("\n--- Поиск по запросу 'вкусно' (по тексту статьи)---");
        Searchable[] results5 = searchEngine.search("вкусно");
        printSearchResults(results5);


    }
}