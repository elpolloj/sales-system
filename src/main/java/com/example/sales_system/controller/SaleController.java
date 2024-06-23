package com.example.sales_system.controller;

import com.example.sales_system.model.Sale;
import com.example.sales_system.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Sale> getAllSales() {
        return saleService.findAll();
    }

    @PostMapping
    public Sale createSale(@RequestBody Sale sale) {
        return saleService.save(sale);
    }

    @PutMapping("/{id}")
    public Sale updateSale(@PathVariable Long id, @RequestBody Sale saleDetails) {
        saleDetails.setId(id);
        return saleService.update(saleDetails);
    }
}
