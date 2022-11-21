package com.jbk.SpringBoot_ProductManagement.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.SpringBoot_ProductManagement.entity.Product;

@Repository
public class ProductDao_Impl implements ProductDao {

	public Logger logger = LogManager.getLogger(ProductDao_Impl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Boolean saveProduct(Product product) {
		Session session = null;
		boolean flag=false;
		try
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("product_name", product.getProduct_name()));
			Product prd = (Product) criteria.uniqueResult();
			if(prd==null)
			{
				Transaction transaction = session.beginTransaction();
				session.save(product);
				transaction.commit();
				flag=true;
			}
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			session.close();
		}
		return flag;
	}
	
	
	@Override
	public Product getProductById(int productId) {
		Session session = null;
		Product product=null;
		try
		{
			session = sessionFactory.openSession();
			product=session.get(Product.class, productId);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			session.close();
		}
		return product;
	
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		List<Product> products=null;
		try
		{
			Criteria criteria=session.createCriteria(Product.class);
			products=criteria.list();   //HQL=>From Product
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			session.close();
		}
		return products;
	}

	@Override
	public Boolean deleteProductById(int productId) {
		Session session = sessionFactory.openSession();
		Product product=null;
		boolean flag=false;
		try
		{
			Transaction transaction = session.beginTransaction();
			product=session.get(Product.class, productId);
			if(product!=null)
			{
				session.delete(product);
				transaction.commit();
				flag=true;
			}
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			session.close();
		}
		return flag;
	}

	@Override
	public Boolean updateProduct(Product product) {
		Session session = null;
		boolean flag=false;
		try
		{
			session=sessionFactory.openSession();
			Product prd = getProductById(product.getProduct_id());
			if(prd!=null)
			{
				Transaction transaction =session.beginTransaction();
				session.update(product);
				transaction.commit();
				flag=true;
			}
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			session.close();
		}
		return flag;
	}
}