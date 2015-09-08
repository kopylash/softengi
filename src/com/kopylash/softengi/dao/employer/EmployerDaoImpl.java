package com.kopylash.softengi.dao.employer;

import com.kopylash.softengi.dao.JpaDao;
import com.kopylash.softengi.entity.Employer;
import org.springframework.stereotype.Repository;

/**
 * Created by Владислав on 09.09.2015.
 */
@Repository
public class EmployerDaoImpl extends JpaDao<Employer,Integer> implements EmployerDao {
    public EmployerDaoImpl() {
        super(Employer.class);
    }
}
