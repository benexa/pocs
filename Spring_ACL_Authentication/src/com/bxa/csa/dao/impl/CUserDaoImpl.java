package com.bxa.csa.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bxa.csa.dao.CUserDao;
import com.bxa.csa.model.CRole;
import com.bxa.csa.model.CUser;

@Repository("userDao")
public class CUserDaoImpl implements CUserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public CUser save(CUser cUser) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(cUser);
		tx.commit();
		session.close();
		return cUser;
	}

	@Override
	public CUser update(CUser cUser) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(cUser);
		tx.commit();
		session.close();
		return cUser;
	}

	@Override
	public boolean delete(CUser cUser) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(cUser);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public CUser get(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		CUser user = session.get(CUser.class, id);
		tx.commit();
		session.close();
		return user;
	}

	@Override
	public Set<CUser> getAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery(" from CUser");
		Set<CUser> users = new HashSet<CUser>(query.list());
		session.close();
		return users;
	}

	@Override
	public Set<CRole> getUserRoles(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(CRole.class);
		criteria.createAlias("listOfUser", "user");
		criteria.add(Restrictions.eq("user.id", id));
		Set<CRole> roles = new HashSet<CRole>(criteria.list());

		tx.commit();
		session.close();
		return roles;
	}

	@Override
	public CUser getByUserName(String username) {
		Session session = sessionFactory.openSession();
		CUser user = session.bySimpleNaturalId(CUser.class).load(username);
		session.close();
		return user;
	}
	
	
	
	
}
