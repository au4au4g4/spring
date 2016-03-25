package model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.ProductBean;
import model.ProductDAO;
@Repository(value="productDAO")
public class ProductDAOHibernate implements ProductDAO {
	
	//spring
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	//crud
	@Override
	public ProductBean select(int id) {
		return (ProductBean)
				this.getSession().get(ProductBean.class, id);
	}
	@Override
	public List<ProductBean> select() {
		Query query =
				this.getSession().createQuery("from ProductBean");
		return (List<ProductBean>) query.list();
	}
	@Override
	public ProductBean insert(ProductBean bean) {
		ProductBean result = (ProductBean)
				this.getSession().get(ProductBean.class, bean.getId());
		if(result==null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}
	@Override
	public ProductBean update(String name,
			double price, Date make, int expire, int id) {
		ProductBean result = (ProductBean)
				this.getSession().get(ProductBean.class, id);
		if(result!=null) {
			result.setName(name);
			result.setPrice(price);
			result.setMake(make);
			result.setExpire(expire);
		}
		return result;
	}
	@Override
	public boolean delete(int id) {
		ProductBean bean = (ProductBean) this.getSession().get(ProductBean.class, id);
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	
	//test
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			sessionFactory.getCurrentSession().beginTransaction();

			ProductDAO dao = (ProductDAO) context.getBean("productDAO");
			ProductBean bean = dao.select(1);
			System.out.println(bean);

			List<ProductBean> beans = dao.select();
			System.out.println(beans);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}
}
