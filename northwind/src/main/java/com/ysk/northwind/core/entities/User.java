package com.ysk.northwind.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


//kullanıcı girişi için oluşturduk
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {  //kullanıcı ile ilgili işlemleri normalde direk entities de tanımlanırdı fakat kullanıcı girişini başka projelerdede kullanılıcağından dolayı core da tanımladık.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Email //spring validationu import ettik
    @NotBlank  //boş olamaz
    @NotNull  //hiç bişey gelmemesi durumu
    @Column(name="email")
    private String email;

    @NotBlank  //boş olamaz
    @NotNull  //hiç bişey gelmemesi durumu
    @Column(name="password")
    private String password;
}
