package com.example.sales_system.service;

import com.example.sales_system.model.Sale;
import com.example.sales_system.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale update(Sale sale) {
        return saleRepository.save(sale);
    }
}
