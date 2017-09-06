package com.phillips.oit.dao;

import java.io.File;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.phillips.oit.bean.OITBean;
import com.phillips.oit.service.OITDaoService;
import com.phillips.oit.sessionFactory.HibernateSessionFactory;

public class OITDao implements OITDaoService{
	static Logger logger = Logger.getLogger(OITDao.class);
	@Override
	public boolean saveOITData(String data) {
		
		return false;
	}

	@Override
	public List<OITBean> getOITData() {
		 String log4jConfigFile = System.getProperty("user.dir")
	                + File.separator + "log4j.xml";
	        DOMConfigurator.configure(log4jConfigFile);
		SessionFactory factory= HibernateSessionFactory.getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
	Query query = session.createQuery("from oitdata");
	List<OITBean> oitdata = query.getResultList();
		for(OITBean oit:oitdata)
		    logger.debug("this is a debug log message" +oit.toString());
        logger.info("this is a information log message");
        logger.warn("this is a warning log message");
	
		session.close();
		factory.close();
		return oitdata;
	}
	public static void main(String args[]){
	new OITDao().getOITData();
	}

}
