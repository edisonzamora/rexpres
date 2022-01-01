package com.rexpress.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


@Repository
public abstract class CommonDaoImpl<ENTITY, PK> extends CrudDaoImpl<ENTITY, PK>{

	private static final Logger logger = LogManager.getLogger(CommonDaoImpl.class);

	private static EntityManagerFactory emf;

	private static EntityManager em;

	static {
		logger.debug("emf=Persistence.createEntityManagerFactory(rexpressPU);");
		try {

			emf = Persistence.createEntityManagerFactory("rexpressPU");
			
			
			
		} catch (PersistenceException e) {
			
			logger.error(e.getMessage());
			logger.error(e.getCause());

		} finally {
			logger.debug("Controlando coneccion");
		}
		// SET GLOBAL time_zone = '-3:00';//
	}

	@Override
	protected EntityManager getEntityManager() throws IllegalStateException{
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
	@Override
	protected Session getSessionManager() {
		// TODO Auto-generated method stub
		return (Session) getEntityManager().getDelegate();
	}

}
