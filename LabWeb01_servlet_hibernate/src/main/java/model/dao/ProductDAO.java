package model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.HibernateUtil;
import model.ProductDAOI;
import model.ProductVO;

public class ProductDAO implements ProductDAOI {

	@Override
	public ProductVO select(Integer id) {
		ProductVO result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			result = session.get(ProductVO.class, id);
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
