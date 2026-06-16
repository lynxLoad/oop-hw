package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 50);
        Product bread = new Product("Хлеб", 35);
        Product milk = new Product("Молоко", 80);
        Product cheese = new Product("Сыр", 120);
        Product juice = new Product("Сок", 95);
        Product extraProduct = new Product("Лишний товар", 999);

        ProductBasket basket = new ProductBasket();

        System.out.println("\n=== Добавление продукта в корзину ===");
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        System.out.println("Добавлено 3 товара.");

        System.out.println("\n=== Добавление продукта в заполненную корзину ===");
        basket.addProduct(cheese);
        basket.addProduct(juice);
        basket.addProduct(extraProduct);

        System.out.println("\n=== Печать содержимого корзины с несколькими товарами ===");
        basket.printBasket();

        System.out.println("\n=== Получение стоимости корзины с несколькими товарами ===");
        int total = basket.getTotalCost();
        System.out.println("Общая стоимость: " + total);

        System.out.println("\n=== Поиск товара, который есть в корзине ===");
        String searchName1 = "Молоко";
        boolean found1 = basket.checkProduct(searchName1);
        System.out.println("Товар '" + searchName1 + "' найден в корзине? " + found1);

        System.out.println("\n=== Поиск товара, которого нет в корзине ===");
        String searchName2 = "Торт";
        boolean found2 = basket.checkProduct(searchName2);
        System.out.println("Товар '" + searchName2 + "' найден в корзине? " + found2);

        System.out.println("\n=== Очистка корзины ===");
        basket.clearBasket();
        System.out.println("Корзина очищена.");

        System.out.println("\n=== Печать содержимого пустой корзины ===");
        basket.printBasket();

        System.out.println("\n=== Получение стоимости пустой корзины ===");
        int emptyTotal = basket.getTotalCost();
        System.out.println("Стоимость пустой корзины: " + emptyTotal);

        System.out.println("\n=== Поиск товара по имени в пустой корзине ===");
        boolean found3 = basket.checkProduct("Яблоко");
        System.out.println("Товар 'Яблоко' найден в пустой корзине? " + found3);
    }
}