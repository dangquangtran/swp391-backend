package com.swp391.admin.model.order_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_ProductRepository extends JpaRepository<Order_Product, Integer> {
}
