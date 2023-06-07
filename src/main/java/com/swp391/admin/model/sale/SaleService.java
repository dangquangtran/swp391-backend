package com.swp391.admin.model.sale;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swp391.admin.model.product.Product;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;
@Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getListSale(){
    return saleRepository.findAll();
    }

    public void createSaleEvent(Sale sale){
        saleRepository.save(sale);
    }

    public Sale findSaleById(int id)
    {
        return saleRepository.findById(id).orElse(null);
    }
    @Transactional
    @Cascade(CascadeType.DELETE)
    public void deleteSale(Sale sale){
        if(sale.getExpiredDate().compareTo(LocalDate.now()) ==0)
            saleRepository.delete(sale);
    }


}
