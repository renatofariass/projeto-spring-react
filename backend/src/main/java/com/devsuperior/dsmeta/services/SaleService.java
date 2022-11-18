package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SaleService {
    @Autowired
    private SaleRepository repository;

    //Page para pegar do banco de dados somente os 20 primeiros resultados
    public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
        //pegando a data de hoje com base no sistema do usuário
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        //data mínima, caso o usuário não passe nada como parâmetro, o sistema por default irá assumir a data mínima de
        //um ano atrás
        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);

        //data máxima, caso o usuário não passe nada como parâmetro, o sistema por default irá assumir o dia de hoje
        //como data máxima
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

        return repository.findSales(min, max, pageable);
    }
}
