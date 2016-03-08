package com.bxa.csa.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bxa.csa.dao.CRoleDao;
import com.bxa.csa.model.CRole;

@Repository("roleDao")
public class CRoleDaoImpl implements CRoleDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public CRole save(CRole cRole) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(cRole);
		tx.commit();
		session.close();
		return cRole;
	}

	@Override
	public CRole update(CRole cRole) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(cRole);
		tx.commit();
		session.close();
		return cRole;
	}

	@Override
	public boolean delete(CRole cRole) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(cRole);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public CRole get(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		CRole crole = session.get(CRole.class, id);
		tx.commit();
		session.close();
		return crole;
	}

	@Override
	public Set<CRole> getAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery(" from CRole");
		Set<CRole> roles = new HashSet<CRole>(query.list());
		session.close();
		return roles;
	}
	
}
