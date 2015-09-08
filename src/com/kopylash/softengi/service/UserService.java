package com.kopylash.softengi.service;

import com.kopylash.softengi.dao.address.AddressDao;
import com.kopylash.softengi.dao.deposit.DepositDao;
import com.kopylash.softengi.dao.employer.EmployerDao;
import com.kopylash.softengi.dao.user.UserDao;
import com.kopylash.softengi.entity.Address;
import com.kopylash.softengi.entity.Deposit;
import com.kopylash.softengi.entity.User;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by Владислав on 08.09.2015.
 */
@Named
public class UserService {
    @Inject
    private UserDao userDao;
    @Inject
    private DepositDao depositDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getById(int id) {
        return userDao.find(id);
    }

    @Transactional(rollbackFor = PersistenceException.class)
    public void createUser(User user) {
        Deposit deposit = user.getDeposit();
        user.setDeposit(null);
        deposit.setUser(userDao.insert(user));
        depositDao.insert(deposit);
    }

    @Transactional(rollbackFor = PersistenceException.class)
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Transactional(rollbackFor = PersistenceException.class)
    public void deleteUser(int userId) {
        userDao.delete(userId);
    }
}
