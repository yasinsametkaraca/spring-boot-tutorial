package com.ysk.northwind.business.abstracts;

import com.ysk.northwind.core.entities.User;
import com.ysk.northwind.core.utilities.results.DataResult;
import com.ysk.northwind.core.utilities.results.Result;




public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);

}
