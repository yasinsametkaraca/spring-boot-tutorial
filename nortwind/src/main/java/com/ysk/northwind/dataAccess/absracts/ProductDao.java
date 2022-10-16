package com.ysk.northwind.dataAccess.absracts;

import com.ysk.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {  //@entity ile yazılan yer için=Product, primary key için integer yazdık. Hangi tabloya (product) hangi id (int) veritipiyle sorguların hazırlanması gerektiğini repository e söylüyoruz.

}
