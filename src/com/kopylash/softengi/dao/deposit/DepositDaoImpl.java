package com.kopylash.softengi.dao.deposit;

import com.kopylash.softengi.dao.JpaDao;
import com.kopylash.softengi.entity.Deposit;
import org.springframework.stereotype.Repository;

/**
 * Created by Владислав on 09.09.2015.
 */
@Repository
public class DepositDaoImpl extends JpaDao<Deposit,Integer> implements DepositDao {
    public DepositDaoImpl() {
        super(Deposit.class);
    }
}
