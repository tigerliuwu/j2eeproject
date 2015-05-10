package edu.dlmu.sei.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import edu.dlmu.sei.bo.HibernateQueryObject;
import edu.dlmu.sei.exception.OverflowException;
import edu.dlmu.sei.exception.RunException;
import edu.dlmu.sei.exception.ValueExistException;

/**
 * 
 * @author stony.feng
 * 
 * 
 * 
 * TODO To change the template for this generated type comment go to Window -
 * 
 * Preferences - Java - Code Style - Code Templates
 * 
 */

public class HibernateDataAccessObject implements DataAccessObject {

	private static Logger logger = Logger

	.getLogger(HibernateDataAccessObject.class);

	private Class clazz;

	protected Serializable id;

	protected Session getSession() {

		return (Session) HibernateQueryObject.SESSION.get();

	}

	protected Connection getConnection() {
		return getSession().connection();
	}

	/**
	 * 
	 * 
	 * 
	 */

	public HibernateDataAccessObject(Class clazz) {

		this.clazz = clazz;

	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * 
	 * 
	 * @see com.eapo.common.dao.DataAccessObject#delete(java.io.Serializable)
	 * 
	 */

	public void delete(Serializable object) throws RunException {

		try {

			getSession().delete(object);

			getSession().flush();

			onDeleteTrigger(object);

		} catch (HibernateException e) {

			handleException(e);

		}

	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * 
	 * 
	 * @see com.eapo.common.dao.DataAccessObject#delete(java.io.Serializable)
	 * 
	 */

	public void deleteByID(Serializable id) {

		delete((Serializable) load(id));

	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * 
	 * 
	 * @see com.eapo.common.dao.DataAccessObject#load(java.lang.Class,
	 * 
	 * java.io.Serializable)
	 * 
	 */

	public Object load(Serializable id) {

		try {

			Object obj = getSession().get(clazz, id);

			if (obj == null)
				obj = getSession().load(clazz, id);
			else
				getSession().refresh(obj);

			return obj;

		} catch (HibernateException e) {

			handleException(e);

		}

		return null;

	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * 
	 * 
	 * @see com.eapo.common.dao.DataAccessObject#loadAndLock(java.io.Serializable)
	 * 
	 */

	public Object loadAndLock(Serializable id) {

		try {

			Object obj = getSession().get(clazz, id);

			if (obj == null)
				obj = getSession().load(clazz, id, LockMode.UPGRADE);
			else {
				if (!LockMode.UPGRADE.equals(getSession().getCurrentLockMode(
						obj)))
					getSession().refresh(obj, LockMode.UPGRADE);

			}

			return obj;

		} catch (HibernateException e) {

			handleException(e);

		}

		return null;

	}

	public void refresh(Serializable id) {

		try {

			Object obj = getSession().get(clazz, id);

			if (obj != null) {
				getSession().refresh(obj);
			}

		} catch (HibernateException e) {

			handleException(e);

		}

	}

	public void evict(Serializable id) {

		try {

			Object obj = getSession().get(clazz, id);

			if (obj != null) {
				getSession().evict(obj);
			}

		} catch (HibernateException e) {

			handleException(e);

		}

	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * 
	 * 
	 * @see com.eapo.common.dao.DataAccessObject#save(java.io.Serializable)
	 * 
	 */

	public Serializable save(Serializable object) {

		try {

			onTriggerBeforeSave(object);

			id = getSession().save(object);

			flush();

			onSaveTrigger(object);

			return id;

		} catch (HibernateException e) {

			handleException(e);

		}

		return null;

	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * 
	 * 
	 * @see com.eapo.common.dao.DataAccessObject#saveOrUpdate(java.io.Serializable)
	 * 
	 */

	public void saveOrUpdate(Serializable object) {

		try {

			getSession().saveOrUpdate(object);

			flush();

			onSaveOrUpdateTrigger(object);

		} catch (HibernateException e) {

			handleException(e);

		}

	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * 
	 * 
	 * @see com.eapo.common.dao.DataAccessObject#saveOrUpdate(java.io.Serializable)
	 * 
	 */

	public void saveOrUpdateBatch(List batch) {

		for (int i = 0; i < batch.size(); i++) {

			saveOrUpdate((Serializable) batch.get(i));

			flush();

			onSaveOrUpdateTrigger(batch.get(i));

		}

	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * 
	 * 
	 * @see com.eapo.common.dao.DataAccessObject#update(java.io.Serializable)
	 * 
	 */

	public void update(Serializable object) {

		try {

			onTriggerBeforeUpdate(object);

			getSession().update(object);

			flush();

			onUpdateTrigger(object);

		} catch (HibernateException e) {

			handleException(e);

		}

	}

	public List query(Serializable vo) {

		try {

			return getSession().createCriteria(clazz).add(Example.create(vo))

			.list();

		} catch (HibernateException e) {

			handleException(e);

		}

		return null;

	}

	public void flush() {

		try {

			getSession().flush();

		} catch (HibernateException e) {

			logger.error(e);

			handleException(e);

		}

	}

	protected void handleException(HibernateException he) {

		logger.error(he);

		RunException ex = null;

		if (he instanceof JDBCException) {

			switch (((JDBCException) he).getErrorCode()) {

			case OracleExceptionConstants.UNIQUE_CONSTRAINTS:

				ex = new ValueExistException(he);

				break;

			case OracleExceptionConstants.NOT_NULL_CONSTRAINTS:

				ex = new RunException(he);

				break;

			case OracleExceptionConstants.INTEGRITY_CONSTRAINTS_PARENT:

				ex = new RunException(he);

				break;

			case OracleExceptionConstants.INTEGRITY_CONSTRAINTS_CHILD:

				ex = new RunException(he);

				break;

			case OracleExceptionConstants.TOO_LARGE:

				ex = new OverflowException(he);

				break;

			default:

				ex = new RunException(he);

			}

		}

		throw ex;

	}

	protected void onSaveOrUpdateTrigger(Object object) {

	}

	protected void onSaveTrigger(Object object) {

	}

	protected void onUpdateTrigger(Object object) {

	}

	protected void onDeleteTrigger(Object object) {

	}

	protected void onTriggerBeforeSave(Object object) {

	}

	protected void onTriggerBeforeUpdate(Object object) {

	}

}