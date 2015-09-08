package com.kopylash.softengi.dao.address;

import com.kopylash.softengi.dao.JpaDao;
import com.kopylash.softengi.entity.Address;
import org.springframework.stereotype.Repository;

/**
 * Created by Владислав on 09.09.2015.
 */
@Repository
public class AddressDaoImpl extends JpaDao<Address,Integer> implements AddressDao {
    public AddressDaoImpl() {
        super(Address.class);
    }
}
