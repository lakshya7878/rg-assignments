package com.example.customersbatch.repository;

import com.example.customersbatch.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
}