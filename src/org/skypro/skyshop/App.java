package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.engine.SearchEngine;

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

        SearchEngine searchEngine = new SearchEngine(10);

        System.out.println("\n=== Добавление товаров в поисковый движок ===");
        searchEngine.add(apple);
        System.out.println("Добавлен: " + apple.getStringRepresentation());
        searchEngine.add(bread);
        System.out.println("Добавлен: " + bread.getStringRepresentation());
        searchEngine.add(milk);
        System.out.println("Добавлен: " + milk.getStringRepresentation());
        searchEngine.add(cheese);
        System.out.println("Добавлен: " + cheese.getStringRepresentation());
        searchEngine.add(juice);
        System.out.println("Добавлен: " + juice.getStringRepresentation());
        searchEngine.add(extraProduct);
        System.out.println("Добавлен: " + extraProduct.getStringRepresentation());

        System.out.println("\n=== Добавление статей в поисковый движок ===");
        Article article1 = new Article("Как выбрать яблоки", "Статья о том, как правильно выбирать свежие яблоки в магазине");
        Article article2 = new Article("Польза молока", "Молоко содержит кальций и полезно для костей");
        Article article3 = new Article("Рецепт яблочного сока", "Как приготовить свежий яблочный сок в домашних условиях");


        searchEngine.add(article1);
        System.out.println("Добавлена статья: " + article1.getName());
        searchEngine.add(article2);
        System.out.println("Добавлена статья: " + article2.getName());
        searchEngine.add(article3);
        System.out.println("Добавлена статья: " + article3.getName());

        System.out.println("\n=== Поиск ===");
        Searchable[] results1 = searchEngine.search("яблоко");
        printSearchResults(results1);

        Searchable[] results2 = searchEngine.search("молоко");
        printSearchResults(results2);

        Searchable[] results3 = searchEngine.search("сок");
        printSearchResults(results3);

        Searchable[] results4 = searchEngine.search("хлеб");
        printSearchResults(results4);

        Searchable[] results5 = searchEngine.search("шоколад");
        printSearchResults(results5);

        Searchable[] results6 = searchEngine.search("как");
        printSearchResults(results6);
    }

    private static void printSearchResults(Searchable[] results) {
        int foundCount = 0;
        for (Searchable item : results) {
            if (item != null) {
                foundCount++;
                System.out.println("Найдено: " + item.getStringRepresentation());
            }
        }
        if (foundCount == 0) {
            System.out.println("Ничего не найдено.");
        } else {
            System.out.println("Всего найдено: " + foundCount);
        }
    }
}