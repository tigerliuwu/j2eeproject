/*



 * Created on 2004-7-12



 *



 * Window - Preferences - Java - Code Style - Code Templates



 */



package edu.dlmu.sei.bo;



import org.apache.log4j.Logger;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;



import edu.dlmu.sei.exception.RunException;



/**

 * @author stony.feng

 * 

 */

public abstract class HibernateBusinessObject extends JTXBusinessObject {



	/**

	 * 

	 * Comment for <code>SESSION</code>

	 * 

	 */



	public static final ThreadLocal SESSION = new ThreadLocal();



	public static final ThreadLocal USER = new ThreadLocal();



	/**

	 * 

	 * Comment for <code>logger</code>

	 * 

	 */



	private static Logger logger = Logger



	.getLogger(HibernateBusinessObject.class);



	/**

	 * 

	 * Comment for <code>sessionFactory</code>

	 * 

	 */



	private static SessionFactory sessionFactory;



	static {



		try {



			if (TRANSLOCAL) {



				sessionFactory = new Configuration().configure()



				.buildSessionFactory();



			} else {



				sessionFactory = new Configuration().configure()



				.buildSessionFactory();



			}



			if (logger.isDebugEnabled()) {



				logger.debug("Init SessionFactory");



			}



		} catch (Exception ex) {



			logger.error(ex);



		}



	}



	/**

	 * 

	 * @return the Session with ThreadLocal

	 * 

	 */



	final protected Session getSession() {



		return (Session) HibernateBusinessObject.SESSION.get();



	}



	/**

	 * 

	 * @see com.bearingpoint.gdc.core.bo.JTXBusinessObject#process()

	 * 

	 */



	final protected void process() {



		boolean flag = false;



		Session session = null;



		try {



			session = getSession();



			logger.debug("get Session" + session);



			Transaction trans = null;



			if (session == null) {



				if (logger.isDebugEnabled()) {



					logger.debug("Create Session");



				}



				session = sessionFactory.openSession();



				flag = true;



				SESSION.set(session);



				ROLL.set(null);



				if (logger.isDebugEnabled()) {



					logger.debug("Begin Transaction");



				}



				if (TRANSLOCAL) {



					trans = session.beginTransaction();



				}



			}



			try {



				performBusinessLogic();



				if (flag) {



					if (logger.isDebugEnabled()) {



						logger.debug("Commit Transaction Begin");



					}



					session.flush();



					if (TRANSLOCAL) {



						if (ROLL.get() == null) {



							trans.commit();



						} else {



							logger.error("Rollback Transaction By ROLL");

							trans.rollback();



						}



					}



					if (logger.isDebugEnabled()) {



						logger.debug("Commit Transaction End");



					}



				}



			} catch (Exception ex) {



				logger.error(ex);



				if (flag) {



					if (logger.isDebugEnabled()) {



						logger.debug("Rollback Transaction Begin");



					}



					if (TRANSLOCAL) {



						trans.rollback();



					}



					if (logger.isDebugEnabled()) {



						logger.debug("Rollback Transaction End");



					}



				}



				if (ex instanceof RunException) {



					throw (RunException) ex;



				}



				throw new RunException(ex);



			}



		} catch (Exception ex) {



			logger.error(ex);



			if (ex instanceof RunException) {



				throw (RunException) ex;



			}



			throw new RunException(ex);



		} finally {



			if (flag) {



				SESSION.set(null);



				ROLL.set(null);



				try {



					if (logger.isDebugEnabled()) {



						logger.debug("Close Session");



					}



					session.close();



				} catch (Exception ex) {



					logger.error(ex);



				}



			}



		}



	}



	/**

	 * 

	 */

	abstract protected void performBusinessLogic();



}