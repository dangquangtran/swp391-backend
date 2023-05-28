package com.swp391.admin.model.bird_sale;

import com.swp391.admin.model.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Bird_Sale_Repository extends JpaRepository<Bird_Sale, Integer> {
    public List<Bird_Sale> findBySale(Sale sale);
}
