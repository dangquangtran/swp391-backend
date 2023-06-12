package com.swp391.admin.controller;

import com.swp391.admin.model.feedback.Feedback;
import com.swp391.admin.model.feedback.FeedbackService;
import com.swp391.admin.model.product.Product;
import com.swp391.admin.model.product.ProductService;
import com.swp391.admin.model.product_sale.Product_Sale;
import com.swp391.admin.model.product_sale.Product_SaleService;
import com.swp391.admin.model.sale.Sale;
import com.swp391.admin.model.sale.SaleService;
import com.swp391.admin.model.user.AdminService;
import com.swp391.admin.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final ProductService productService;

    private final SaleService saleService;

    private final Product_SaleService product_saleService;

    private final FeedbackService feedbackService;

    @Autowired
    public AdminController(AdminService adminService, ProductService productService, SaleService saleService, Product_SaleService product_saleService, FeedbackService feedbackService) {
        this.adminService = adminService;
        this.productService = productService;
        this.saleService = saleService;
        this.product_saleService = product_saleService;
        this.feedbackService = feedbackService;
    }





    @GetMapping("/user")
    public List<User> getListUser() {
        return adminService.getListUser();
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        adminService.createUser(user);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String lastname) {
        adminService.deleteUser(lastname);
    }

    @PutMapping("/user")
    public void updateUser(@RequestParam int id,
                           @RequestParam String firstname,
                           @RequestParam String lastname) {
        adminService.updateUser(id, firstname, lastname);
    }

    @GetMapping("/user/searchbyemail")
    public List<User> searchUserByEmail(@RequestParam String email) {
        return adminService.searchUserByEmail(email);
    }

    @GetMapping("/user/searchbyname")
    public List<User> searchUserByLastName(@RequestParam String lastname) {
        return adminService.searchUserByLastName(lastname);
    }

    @GetMapping("/user/searchbyrole")
    public List<User> searchUserByRole(@RequestParam String role) {
        return adminService.searchUserByRole(role);
    }


    @GetMapping("/product")
    public List<Product> getListProduct() {
        return productService.getListProduct();
    }

    @PostMapping("/product")
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @GetMapping("/product/searchbyid")
    public Product getProductById(@RequestParam int productId) {
        return productService.getProductById(productId);
    }


    @GetMapping("/sale")
    public List<Sale> getListSale() {
        return saleService.getListSale();
    }

    @PostMapping("/sale")
    public void createSaleEvent(@RequestBody Sale sale) {
        saleService.createSaleEvent(sale);
    }

    @GetMapping("/sale/searchbyid")
    public Sale getSaleById(@RequestParam int saleId) {
        return saleService.findSaleById(saleId);
    }

    @DeleteMapping("/sale")
    public void deleteSale(@RequestParam int saleId) {
        saleService.deleteSale(saleId);
    }


    @GetMapping("/productsale")
    public List<Product_Sale> getListProductSale() {
        return product_saleService.getListProductSale();
    }

    @PostMapping("/productsale")
    public void createProductSale(@RequestBody Product_Sale product_sale,
                                  @RequestParam int productId,
                                  @RequestParam int saleId) {
        product_saleService.createProductSale(product_sale, productId, saleId);
    }

    @GetMapping("/productsale/getproduct")
    public List<Product> getProductInSaleEvent(@RequestParam int saleId) {
        return product_saleService.getProductInSaleEvent(saleId);
    }


    @GetMapping("/feedback")
    public List<Feedback> getListFeedback(){
        return feedbackService.getListFeedback();
    }

    @PostMapping("/feedback")
    public void createFeedback(@RequestBody Feedback feedback,
                               @RequestParam int productId){
        feedbackService.createFeedback(feedback,productId);
    }
}

