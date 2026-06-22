package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products;
    private int count;

    public ProductBasket() {
        this.products = new Product[5];
        this.count = 0;
    }

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < count; i++) {
            totalCost += products[i].getPrice();
        }
        return totalCost;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто");
        } else {
            int specialCount = 0;
            for (int i = 0; i < count; i++) {
                Product product = products[i];
                System.out.println(product.toString());
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
            System.out.println("Итого: " + getTotalCost());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public boolean checkProduct(String name) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        count = 0;
    }
}