package com.nagarro.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.entity.User;
import com.nagarro.utility.DbSession;


public class UserDetailDaoImpl implements UserDetailDao {
    /*
      Reading User detail from database
      */
        @SuppressWarnings("deprecation")
		@Override
        public boolean readUserDetail (User user){

            int count=0;
            Session session = DbSession.getSession();
            try {
                session.beginTransaction();
                Criteria criteria = session.createCriteria(User.class);
                criteria.add(Restrictions.eq("username", user.getUsername()));
                criteria.add(Restrictions.eq("password", user.getPassword()));
                count = criteria.list().size();

                session.getTransaction().commit();

            } catch (Exception ex) {
                session.getTransaction().rollback();
                throw ex;
            }
            if(count>0)
            return true;
            else
                return false;
        }

}
