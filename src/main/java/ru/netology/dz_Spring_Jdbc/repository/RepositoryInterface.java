package ru.netology.dz_Spring_Jdbc.repository;

import ru.netology.dz_Spring_Jdbc.model.Customers;

import java.util.List;

public interface RepositoryInterface {
    List<String> getProductName(String name);

    List<Customers> getAllElementsName(String name);

}
