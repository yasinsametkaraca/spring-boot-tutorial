package com.ysk.northwind.business.abstracts;

import com.ysk.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
