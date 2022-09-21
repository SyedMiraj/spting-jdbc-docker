package com.miraj.springjdbcdocker.repo;

import com.miraj.springjdbcdocker.enity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
