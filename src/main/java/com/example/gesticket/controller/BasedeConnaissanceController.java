package com.example.gesticket.controller;

import com.example.gesticket.modele.BasedeConnaissances;
import com.example.gesticket.service.BasedeConnaissanceService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basedeConnaissance")
@Data
public class BasedeConnaissanceController {
    @Autowired
    private BasedeConnaissanceService basedeConnaissanceService;

    @PostMapping("/create")
    public BasedeConnaissances create(@RequestBody BasedeConnaissances basedeConnaissances){
        return basedeConnaissanceService.create(basedeConnaissances);
    }

    @PutMapping("/update/{id}")
    public BasedeConnaissances update(@RequestBody BasedeConnaissances basedeConnaissances , @PathVariable int id){
        return basedeConnaissanceService.update(basedeConnaissances , id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return basedeConnaissanceService.deleteBasedeConnaissances(id);
    }

    @GetMapping
    public List<BasedeConnaissances> getAll(){
        return basedeConnaissanceService.getAllBasedeConnaissances();
    }

}
