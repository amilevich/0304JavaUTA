package com.projecttwo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Address;

@Repository("addressRepo")
@Transactional
public class AddressDao {

	@Autowired
	private SessionFactory sesFact;

	public AddressDao() {
	}

	public void insert(Address address) {
		sesFact.getCurrentSession().save(address);
	}

	public Address selectById(int id) {
		return sesFact.getCurrentSession().get(Address.class, id);
	}

	public List<Address> selectAll() {
		List<Address> addresslist = sesFact.getCurrentSession().createQuery("from Address", Address.class).list();
		return addresslist;
	}

}
