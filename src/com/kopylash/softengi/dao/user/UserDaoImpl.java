package com.kopylash.softengi.dao.user;

import com.kopylash.softengi.dao.JpaDao;
import com.kopylash.softengi.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Владислав on 08.09.2015.
 */
@Repository
public class UserDaoImpl extends JpaDao<User,Integer> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }
}
