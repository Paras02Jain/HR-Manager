package com.nagarro.dao;

import com.nagarro.entity.User;



public interface UserDetailDao {
    /*
  Reading user Detail from database
  */
    boolean readUserDetail(User user);
}
