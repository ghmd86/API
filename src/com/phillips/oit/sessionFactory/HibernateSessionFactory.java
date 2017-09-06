package com.phillips.oit.sessionFactory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateSessionFactory {
	 private static final StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	    static {
	        try {
	            // Create the SessionFactory from hibernate.cfg.xml
	        	 registry = new StandardServiceRegistryBuilder()
	    				.configure() // configures settings from hibernate.cfg.xml
	    				.build();
	        } catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	        	ex.printStackTrace();
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	   
		return	sessionFactory = new MetadataSources( registry ).addPackage("com.phillips.oit.bean").addAnnotatedClassName("com.phillips.oit.bean.OITBean").buildMetadata().buildSessionFactory();
	    }
}
