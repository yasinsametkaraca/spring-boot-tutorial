package com.ysk.northwind.api.controllers;

import com.ysk.northwind.business.abstracts.ProductService;
import com.ysk.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //sen bir controller sın diyoruz spring e. Api Business katmanına, Business katmanı DataAccess katmanına istekde bulunur.
@RequestMapping("/api/products") ///api/products diye istek gelirse bu class karşılar. Birden çok modül için birden fazla controller olabilir.
public class ProductsController {  //Api kısmıdır. Dış dünyayla iletişim kurulan yerdir.


    private ProductService productService;

    @Autowired /*//bana ProductService lazım diyoruz. Projeyi tarar ProductService i implements eden ProductManager i bulur. Sonra spring arka planda ProductManager productmanager=new ProductManager(); yapar. Sonra ProductDao ya ihtiyaç duyar new ProductDao yapar. Sonra ProductsController da constructor a yerleştirir. */
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall") //bu isteğin get olacağını söylüyoruz. mesela sitemizin adı ysk.com olsun = ysk.com/api/products/getall diye istek gelirse bu metod çalışır.
    public List<Product> getAll() {
        return this.productService.getAll();
    }

}
