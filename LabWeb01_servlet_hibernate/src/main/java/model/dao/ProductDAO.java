package model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.HibernateUtil;
import model.ProductDAOI;
import model.ProductVO;

public class ProductDAO implements ProductDAOI {
	
	SessionFactory SessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}

	@Override
	public ProductVO select(Integer id) {
		ProductVO result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			result = (ProductVO) session.get(ProductVO.class, id);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ProductVO> select() {
		List<ProductVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from ProductVO");
			result=query.list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ProductVO insert(ProductVO productVO) {
		ProductVO result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(productVO);
			tx.commit();
			result=productVO;
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ProductVO update(ProductVO productVO) {
		ProductVO result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(productVO);
			tx.commit();
			result=productVO;
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean delete(Integer id) {
		boolean result = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			ProductVO vo = new ProductVO();
			vo.setId(id);
			session.delete(vo);
			tx.commit();
			result=true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

}
