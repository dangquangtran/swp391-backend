package com.swp391.admin.model.bird_sale;

import com.swp391.admin.model.product.Product;
import com.swp391.admin.model.product.ProductService;
import com.swp391.admin.model.sale.Sale;
import com.swp391.admin.model.sale.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final ProductService productService;
    private final SaleService saleService;
    private final Bird_Sale_Repository repo;

    @GetMapping("/add")
    public String add()
    {
        Product bird1 = new Product();
        bird1.setName("chim cu");
        bird1.setPrice(10000);
        bird1.setQuantity(100);

        Product bird2 = new Product();
        bird2.setName("chim chao mao");
        bird2.setPrice(10000);
        bird2.setQuantity(100);

        productService.createProduct(bird1);
        productService.createProduct(bird2);

        Sale saleEvent = new Sale();
        saleEvent.setName("Summer Sale");
        saleEvent.setDescribe("Mua he nong lam");
        saleEvent.setSale_percent(10);
        saleService.createSaleEvent(saleEvent);

        Bird_Sale birdSale = new Bird_Sale();
        birdSale.setSale(saleEvent);
        birdSale.setBird(bird1);
        repo.save(birdSale);

        Bird_Sale birdSale2 = new Bird_Sale();
        birdSale2.setSale(saleEvent);
        birdSale2.setBird(bird2);
        repo.save(birdSale2);

        return "OK";
    }

    @GetMapping
    public List<Product> test(@RequestParam("id") int sale_id)
    {
        Sale sale = saleService.findSaleById(sale_id);
        List<Bird_Sale> birdSales = repo.findBySale(sale);
        var birds = birdSales.stream().map(a -> a.getBird()).collect(Collectors.toList());
        return birds;
    }
}
