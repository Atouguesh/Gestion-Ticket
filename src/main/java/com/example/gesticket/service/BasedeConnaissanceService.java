package com.example.gesticket.service;

import com.example.gesticket.modele.BasedeConnaissances;

import java.util.List;

public interface BasedeConnaissanceService {
    BasedeConnaissances create(BasedeConnaissances basedeConnaissances);
    BasedeConnaissances update(BasedeConnaissances basedeConnaissances , Long id);
    List<BasedeConnaissances> getAllBasedeConnaissances();
    String deleteBasedeConnaissances(Long id);
}
