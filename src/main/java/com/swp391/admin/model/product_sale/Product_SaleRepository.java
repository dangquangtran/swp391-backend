package com.swp391.admin.model.product_sale;

import com.swp391.admin.model.product.Product;
import com.swp391.admin.model.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Product_SaleRepository extends JpaRepository<Product_Sale, Integer> {
    public List<Product_Sale> findBySale(Sale sale);
    @Query(value = "Select product_id from product_sale where sale_id=?1" , nativeQuery = true)
    public List<Integer> findBySaleId(int saleid);
}
