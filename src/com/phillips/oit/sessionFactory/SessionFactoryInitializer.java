package com.phillips.oit.sessionFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletFactoryInitializer
 *
 */
@WebListener
public class SessionFactoryInitializer implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SessionFactoryInitializer() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	HibernateSessionFactory.getSessionFactory().close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	HibernateSessionFactory.getSessionFactory();
    }
	
}
