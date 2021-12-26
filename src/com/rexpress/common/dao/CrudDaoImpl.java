package com.rexpress.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public abstract class CrudDaoImpl<ENTITY, PK> implements CrudDao<ENTITY, PK>  {

	protected abstract EntityManager getEntityManager() ;
	
	
	/**
	 * 
	 * metodo de la interface implementadao 
	 * convertida abract para gestinarla en la implementacion common
	 * **/
	public abstract Class<ENTITY> getDaoTypeClass();
	
	
	
	/**
	 * delega laconececcion a gestor de sesiones de hibernate
	 * 
	 * **/
	protected abstract Session getSessionManager() ;
	
	
	protected Query createNamedQuery(String name) {
		return getEntityManager().createNamedQuery(name);
	}

	protected Query createHQLQuery(String query) {
		return getEntityManager().createQuery(query);
	}

	protected Query createNativeQuery(String query) {
		return getEntityManager().createNativeQuery(query);
	}

}
