package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        Product apple = new SimpleProduct("Яблоко", 50);
        Product bread = new SimpleProduct("Хлеб", 35);
        Product milk = new DiscountedProduct("Молоко", 80, 15);  // скидка 15%
        Product cheese = new DiscountedProduct("Сыр", 120, 10);   // скидка 10%
        Product juice = new FixPriceProduct("Сок");
        Product extraProduct = new FixPriceProduct("Лишний товар");

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