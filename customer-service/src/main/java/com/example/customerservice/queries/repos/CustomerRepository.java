package com.example.customerservice.queries.repos;

import com.example.customerservice.queries.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
