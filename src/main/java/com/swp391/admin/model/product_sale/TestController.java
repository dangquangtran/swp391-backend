package com.swp391.admin.model.product_sale;

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
    private final Product_SaleRepository repo;

    @GetMapping("/add")
    public String add() {
        Product product1 = new Product();
        product1.setName("chim cu");
        product1.setPrice(10000);
        product1.setQuantity(100);

        Product product2 = new Product();
        product2.setName("chim chao mao");
        product2.setPrice(10000);
        product2.setQuantity(100);

        productService.createProduct(product1);
        productService.createProduct(product2);

        Sale saleEvent = new Sale();
        saleEvent.setName("Summer Sale");
        saleEvent.setDescribe("Mua he nong lam");
        saleEvent.setSale_percent(10);
        saleService.createSaleEvent(saleEvent);

        Product_Sale productSale = new Product_Sale();
        productSale.setSale(saleEvent);
        productSale.setProduct(product1);
        repo.save(productSale);

        Product_Sale productSale2 = new Product_Sale();
        productSale2.setSale(saleEvent);
        productSale2.setProduct(product2);
        repo.save(productSale2);

        return "OK";
    }

    @GetMapping
    public List<Product> test(@RequestParam("id") int sale_id) {
        Sale sale = saleService.findSaleById(sale_id);
        List<Product_Sale> productSales = repo.findBySale(sale);
        var products = productSales.stream().map(a -> a.getProduct()).collect(Collectors.toList());
        return products;
    }
}
