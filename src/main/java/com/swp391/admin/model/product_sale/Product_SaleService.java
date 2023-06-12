package com.swp391.admin.model.product_sale;

import com.swp391.admin.model.product.Product;
import com.swp391.admin.model.product.ProductService;
import com.swp391.admin.model.sale.Sale;
import com.swp391.admin.model.sale.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Product_SaleService {
    private final Product_SaleRepository product_saleRepository;

    private final ProductService productService;
    private final SaleService saleService;

    @Autowired
    public Product_SaleService(Product_SaleRepository product_saleRepository, ProductService productService, SaleService saleService) {
        this.product_saleRepository = product_saleRepository;
        this.productService = productService;
        this.saleService = saleService;
    }


    public List<Product_Sale> getListProductSale() {
        return product_saleRepository.findAll();
    }

    public void createProductSale(Product_Sale product_sale, int productId, int saleId) {
        Product product = productService.getProductById(productId);
        product_sale.setProduct(product);
        Sale sale = saleService.findSaleById(saleId);
        product_sale.setSale(sale);
        product_saleRepository.save(product_sale);
    }

    public List<Product> getProductInSaleEvent(int saleId) {
        Sale sale = saleService.findSaleById(saleId);
        List<Product_Sale> list = product_saleRepository.findBySale(sale);
        return list.stream().map(p -> p.getProduct()).collect(Collectors.toList());
    }


}
