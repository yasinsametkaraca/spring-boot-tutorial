package com.ysk.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data //lombok otomatik constructor ve get set metodları getirir.
@Entity //hangi katmana denk geliyor onu belirtiyoruz
@Table(name="products")  //veritabanında hangi tabloya denk geliyor
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //bir bir arttırılacak diyoruz
    @Column(name="product_id")
    private int id;

    /*@Column(name="category_id") //artık aşağıda yazdığımız kod ile category_id yi tutmamıza gerek yok.
    private int categoryId;*/

    @Column(name="product_name")
    private String productName;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private short unitsInStock;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    @ManyToOne()
    @JoinColumn(name = "category_id") //category_id ler her iki tabloda da ortaktır. Bu ortaklıkla tabloları birleştirebilicez. Ayrıca buraya categoryId koyulur yani üste yazmamıza gerek yok.
    private Category category;  /*her ürünün bir kategorisi vardır. Orda yapılanın tersi burda yapılır*/
}
