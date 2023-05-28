package com.swp391.admin.model.bird_sale;

import com.swp391.admin.model.product.Product;
import com.swp391.admin.model.sale.Sale;

public class main {

    public static void main(String[] args) {
        Sale saleEvent = new Sale();
        saleEvent.setName("Summer Sale");
        saleEvent.setDescribe("Mua he nong lam");
        saleEvent.setSale_percent(10);

        Product bird1 = new Product();
        bird1.setName("chim cu");
        bird1.setPrice(10000);
        bird1.setQuantity(100);

        Product bird2 = new Product();
        bird2.setName("chim chao mao");
        bird2.setPrice(10000);
        bird2.setQuantity(100);

        Bird_Sale birdSale = new Bird_Sale();
        birdSale.setBird(bird1);
        birdSale.setSale(saleEvent);

        Bird_Sale birdSale2 = new Bird_Sale();
        birdSale2.setBird(bird2);
        birdSale2.setSale(saleEvent);


    }
}
