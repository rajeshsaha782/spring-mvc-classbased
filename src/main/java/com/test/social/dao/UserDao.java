package com.test.social.dao;

import com.test.social.model.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDao extends BaseDao {

    public List<User> getAllUser(){
        try{
            List<User> userList = super.getCurrentHibernateSession().createQuery(" from User").list();
            return userList;
        }catch (Exception e){
             e.printStackTrace();
        }
        return null;
    }
}
