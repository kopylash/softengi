package com.kopylash.softengi.service;

import com.kopylash.softengi.dao.deposit.DepositDao;
import com.kopylash.softengi.dao.user.UserDao;
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

    /**
     * Method to get all users from database
     * @return list of users
     */
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    /**
     * Finds user by id
     * @param id
     * @return User with certain id
     */
    public User getById(int id) {
        return userDao.find(id);
    }

    /**
     * Creates User entity and persists it to DB.
     * Cascade persist of all nested entities
     * @param user new entry
     */
    @Transactional(rollbackFor = PersistenceException.class)
    public void createUser(User user) {
        Deposit deposit = user.getDeposit();
        user.setDeposit(null);
        deposit.setUser(userDao.insert(user));
        depositDao.insert(deposit);
    }

    /**
     * Merges user entity with persistence context.
     * @param user entity to update
     */
    @Transactional(rollbackFor = PersistenceException.class)
    public void updateUser(User user) {
        userDao.save(user);
    }

    /**
     * Deletes user from database, also performs cascade deleting of certain Deposit entity
     * @see com.kopylash.softengi.entity.Deposit Deposit
     * @param userId id of entity to delete
     */
    @Transactional(rollbackFor = PersistenceException.class)
    public void deleteUser(int userId) {
        userDao.delete(userId);
    }
}
