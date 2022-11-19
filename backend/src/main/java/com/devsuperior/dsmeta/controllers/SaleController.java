package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/sales")

public class SaleController {
    @Autowired
    private SaleService service;
    @Autowired
    private SmsService smsService;

    //requisição get, que busca por vendedores
    @GetMapping
    public Page<Sale> findSales(@RequestParam(value="minDate", defaultValue="") String minDate,
                                @RequestParam(value="maxDate", defaultValue="") String maxDate,
                                Pageable pageable) {
        return service.findSales(minDate, maxDate, pageable);
    }

    @GetMapping("/notification/{id}")
    public void notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
    }
}
