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

import com.book.dao.PaperBookDao;
import com.book.model.PaperBookMd;

@Repository("paperBookDao")
public class PaperBookDaoImpl implements PaperBookDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public List<PaperBookMd> queryAllBook(Long accountId) throws Exception {
		List<PaperBookMd> paperBookMds = hibernateTemplate.execute(new HibernateCallback<List<PaperBookMd>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<PaperBookMd> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Criteria criteria = session.createCriteria(PaperBookMd.class);
				criteria.add(Restrictions.eq("accountId", accountId));
				criteria.setFirstResult(0);
				criteria.setMaxResults(Integer.MAX_VALUE);
				return criteria.list();
			}
		});
		return paperBookMds;
	}

	@Override
	public void insertBook(PaperBookMd paperBookMd) throws Exception {
		hibernateTemplate.save(paperBookMd);
	}

	@Override
	public PaperBookMd queryBookById(Long paperBookId) throws Exception {
		List<PaperBookMd> paperBookMds = hibernateTemplate.execute(new HibernateCallback<List<PaperBookMd>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<PaperBookMd> doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(PaperBookMd.class);
				criteria.add(Restrictions.eq("paperBookId", paperBookId));
				criteria.setFirstResult(0);
				criteria.setMaxResults(Integer.MAX_VALUE);
				return criteria.list();
			}
		});
		return paperBookMds.get(0);
	}

	@Override
	public List<PaperBookMd> queryAllBook() throws Exception {
		List<PaperBookMd> paperBookMds = hibernateTemplate.execute(new HibernateCallback<List<PaperBookMd>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<PaperBookMd> doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(PaperBookMd.class);
				criteria.setFirstResult(0);
				criteria.setMaxResults(Integer.MAX_VALUE);
				return criteria.list();
			}
		});
		return paperBookMds;
	}

}
