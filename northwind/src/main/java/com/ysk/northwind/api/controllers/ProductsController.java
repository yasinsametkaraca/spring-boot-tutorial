package com.ysk.northwind.api.controllers;

import com.ysk.northwind.business.abstracts.ProductService;
import com.ysk.northwind.core.utilities.results.DataResult;
import com.ysk.northwind.core.utilities.results.Result;
import com.ysk.northwind.entities.concretes.Product;
import com.ysk.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product)  {  //requestbody product bilgilerini (eklenen) json datasına çevirip dönderiyor.
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){  //RequestParam ın mantığı yapılan isteğin parametresine bak onu oku.
        return this.productService.getByProductName(productName);
    }
    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategoryId(productName,categoryId);
    }
    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo,int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }
    @GetMapping("/getAllSortedProductNameDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }
    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>>getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }


    /*@GetMapping("/getall") //bu isteğin get olacağını söylüyoruz. mesela sitemizin adı ysk.com olsun = ysk.com/api/products/getall diye istek gelirse bu metod çalışır.
    public List<Product> getAll() {
        return this.productService.getAll();
    }*/

}
