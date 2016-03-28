package model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.CustomerDAOI;
import model.CustomerVO;
import model.HibernateUtil;

public class CustomerDAO implements CustomerDAOI{

	@Override
	public CustomerVO select(String custid) {
		CustomerVO result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
				
		try {
			tx=session.beginTransaction();
			result=session.get(CustomerVO.class, custid);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean update(CustomerVO customervo) {
		boolean result = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
				
		try {
			tx=session.beginTransaction();
			session.saveOrUpdate(customervo);
			tx.commit();
			result=true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

}
