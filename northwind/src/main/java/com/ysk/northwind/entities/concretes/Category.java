package com.ysk.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
@Entity //veritabanı tablosu demektir.
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "products"}) //bizim verdiğimiz kadar sorguyu yaz diplere girme.
public class Category {

    @Id
    @Column(name="category_id")
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;

    @OneToMany(mappedBy="category")  //Bir categoride birden fazla ürün olur. Bide burada category yazdık çünkü product tarafında zaten categoryId ye göre belirttik.
    private List<Product> products;        /*product tablosu ile arasında one to many ilişki olduğunu söylüyoruz. Bir categorynin birden fazla ürünü olabilir.*/
}

