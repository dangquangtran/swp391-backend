package com.swp391.admin.controller;

import com.swp391.admin.model.product.Product;
import com.swp391.admin.model.product.ProductService;
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
    @Autowired
    public AdminController(AdminService adminService , ProductService productService, SaleService saleService) {
        this.adminService = adminService;
        this.productService = productService;
        this.saleService = saleService;
    }



    @GetMapping("/user")
    public List<User> getListUser(){
        return adminService.getListUser();
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        adminService.createUser(user);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String lastname){
        adminService.deleteUser(lastname);
    }

    @PutMapping("/user")
    public void updateUser(@RequestParam int id,
                           @RequestParam String firstname,
                           @RequestParam String lastname){
        adminService.updateUser(id,firstname,lastname);
    }

    @GetMapping("/user/searchbyemail")
    public List<User> searchUserByEmail(@RequestParam String email){
        return adminService.searchUserByEmail(email);
    }

    @GetMapping("/user/searchbyname")
    public List<User> searchUserByLastName(@RequestParam String lastname){
        return adminService.searchUserByLastName(lastname);
    }
    @GetMapping("/user/searchbyrole")
    public List<User> searchUserByRole(@RequestParam String role){
        return adminService.searchUserByRole(role);
    }



    @GetMapping("/product")
    public List<Product> getListProduct(){
       return productService.getListProduct();
    }
    @PostMapping("/product")
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }
//    @GetMapping("/bird/getlistbirdsale")
//    public List<Bird> getListBirdSale(){
//        return birdService.getListBirdSale();
//    }


    @GetMapping("/sale")
    public List<Sale> getListSale(){
        return saleService.getListSale();
    }

    @PostMapping("/sale")
    public void createSaleEvent(@RequestParam Sale sale){
        saleService.createSaleEvent(sale);
    }

}
