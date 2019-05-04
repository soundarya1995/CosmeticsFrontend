package com.ecom.DBconfig;

import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecom.DAO.CategoryDAO;
import com.ecom.DAO.CategoryDAOImpl;
import com.ecom.DAO.ProductDAO;
import com.ecom.DAO.ProductDAOImpl;
import com.ecom.DAO.SupplierDAO;
import com.ecom.DAO.SupplierDAOImpl;
import com.ecom.Model.Category;
import com.ecom.Model.Product;
import com.ecom.Model.Supplier;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecom")
public class DBconfig 
{
	
	@Bean(name="datasource")
	public DataSource getH2DataSource()
	{
		
		 DriverManagerDataSource datasource= new DriverManagerDataSource();
		
		 datasource.setDriverClassName("org.h2.Driver");
		 datasource.setUrl("jdbc:h2:tcp://localhost/~/ecomdb");
		datasource.setUsername("sound");
		datasource.setPassword("sound");
		System.out.println("Datasource object created");
		return  datasource;
	}
   
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
    	
		Properties properties=new Properties();
		
		properties.put("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder (getH2DataSource());
        sessionBuilder.addProperties(properties);
        sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
	    sessionBuilder.addAnnotatedClass(Product.class);
		System.out.println("Session Factory Object Created");
		return sessionBuilder.buildSessionFactory();
	}
 
	@Bean(name="TransactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		
		System.out.println("Transaction Manager Object Created");
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("----Category DAO Implementation---");
		return new CategoryDAOImpl();
	}
	
	  @Bean(name="productDAO") public ProductDAO getProductDAO() 
	  {
	  System.out.println("----Product DAO Implementation----");
	  return new ProductDAOImpl();
	  }
	 
	  @Bean(name="supplierDAO")
	  public SupplierDAO getSupplierDAO()
	  {
	  System.out.println("----Supplier DAO Implementation---");
	  return new SupplierDAOImpl(); 
	  }
	 
	}

