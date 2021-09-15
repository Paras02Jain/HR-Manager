package com.nagarro.services;

import com.nagarro.dao.UserDetailDao;
import com.nagarro.dao.UserDetailDaoImpl;
import com.nagarro.entity.User;

public class UserDetailServiceImpl implements UserDetailService{
    private UserDetailDao userDao;
    public UserDetailServiceImpl()
    {
        userDao = new UserDetailDaoImpl();

    }
    @Override
    public boolean getUserDetails(User user) {
        try {
            return userDao.readUserDetail(user);
        }
        catch (Exception ex)
        {
            throw  ex;
        }
    }

}
