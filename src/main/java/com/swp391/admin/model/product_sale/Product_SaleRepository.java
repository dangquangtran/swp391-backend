package com.swp391.admin.model.product_sale;

import com.swp391.admin.model.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Product_SaleRepository extends JpaRepository<Product_Sale, Integer> {
    public List<Product_Sale> findBySale(Sale sale);

}
