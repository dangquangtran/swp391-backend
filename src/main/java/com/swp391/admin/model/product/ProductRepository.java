package com.swp391.admin.model.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select p.*\n" +
            "from feedback f\n" +
            "inner join product p on f.product_id = p.id\n" +
            "group by p.id\n" +
            "having avg(f.star)<2.5 ", nativeQuery = true)
    List<Product> getListLowrateProduct();


}
