package ru.netology.dz_Spring_Jdbc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.dz_Spring_Jdbc.model.Customers;
import ru.netology.dz_Spring_Jdbc.repository.RepositoryInterface;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products/fetch-product")
public class ControllerJdbc {

    private RepositoryInterface repository;

    @GetMapping
    public List<String> getProductName(@RequestParam(value = "name", required = false) String name) {
        return repository.getProductName(name.toLowerCase());
    }

    @GetMapping("/1")
    public List<Customers> getAllElementsName(@RequestParam("name") String name) {
        return repository.getAllElementsName(name);
    }

}
