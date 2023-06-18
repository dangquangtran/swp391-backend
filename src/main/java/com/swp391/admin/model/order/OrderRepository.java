package com.swp391.admin.model.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select sum(o.total_price) from _order o", nativeQuery = true)
    double getRevenue();
}
