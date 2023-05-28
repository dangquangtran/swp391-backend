package com.swp391.admin.model.sale;

import com.swp391.admin.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
