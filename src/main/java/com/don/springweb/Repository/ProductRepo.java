package com.don.springweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.don.springweb.model.Product;

@Repository//This annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
//rember to use LocalHost:8080/h2-console to check the database
public interface ProductRepo extends JpaRepository<Product, Integer> {
    
}
