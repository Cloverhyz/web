package com.book.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.book.dao.AccountInfoDao;
import com.book.model.AccountInfoMd;

@Repository("accountInfoDao")
public class AccountInfoDaoImpl implements AccountInfoDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	public AccountInfoMd queryByName(final String accountName) throws Exception {
		List<AccountInfoMd> accountInfoMds = hibernateTemplate.execute(new HibernateCallback<List<AccountInfoMd>>() {
			@SuppressWarnings("unchecked")
			public List<AccountInfoMd> doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(AccountInfoMd.class);
				criteria.add(Restrictions.eq("accountName", accountName));
				criteria.setFirstResult(0);
				criteria.setMaxResults(Integer.MAX_VALUE);
				return criteria.list();
			}
		});
		return accountInfoMds.get(0);
	}
	@Override
	public void insertAccount(AccountInfoMd accountInfoMd) throws Exception {
		hibernateTemplate.getSessionFactory().getCurrentSession().save(accountInfoMd);
	}

}
