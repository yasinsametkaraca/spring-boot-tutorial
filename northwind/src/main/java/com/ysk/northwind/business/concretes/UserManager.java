package com.ysk.northwind.business.concretes;

import com.ysk.northwind.business.abstracts.UserService;
import com.ysk.northwind.core.dataAccess.UserDao;
import com.ysk.northwind.core.entities.User;
import com.ysk.northwind.core.utilities.results.DataResult;
import com.ysk.northwind.core.utilities.results.Result;
import com.ysk.northwind.core.utilities.results.SuccessDataResult;
import com.ysk.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;  //injection yaptık.

    @Autowired  //userDao yu implement eden nesnenin referansını bize verir.
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("User added successfully");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email),"User found." );

    }
}
