package com.example.inventoryservice.queries.repositories;

import com.example.inventoryservice.queries.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

