package com.ysk.northwind.core.dataAccess;

import com.ysk.northwind.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email); //findBy direk dinamik isimdir. İsimlendirmeyle sorgu yazmış olduk getBy la aynıdır.
}
