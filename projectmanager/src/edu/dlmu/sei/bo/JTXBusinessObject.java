/*



 * Created on 2004-6-28



 *



 * To change the template for this generated file go to



 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments



 */



package edu.dlmu.sei.bo;



import javax.naming.Context;



import javax.naming.InitialContext;



import javax.transaction.UserTransaction;



import org.apache.log4j.Logger;



/**

 * @author stony.feng

 * 

 */

public abstract class JTXBusinessObject {



	public static final boolean TRANSLOCAL = true;



	public static final ThreadLocal JTA = new ThreadLocal();



	public static final ThreadLocal ROLL = new ThreadLocal();



	private static Logger logger = Logger.getLogger(JTXBusinessObject.class);



	public void execute() {



		if (TRANSLOCAL) {



			process();



			return;



		}



		if (logger.isDebugEnabled())



			logger.debug("USE JTATransaction");



		boolean flag = false;



		UserTransaction tx = null;



		try {



			tx = (UserTransaction) JTA.get();



			if (tx == null) {



				Context ctx = new InitialContext();



				tx = (UserTransaction) ctx

						.lookup("javax.transaction.UserTransaction");



				flag = true;



				JTA.set(tx);



				tx.begin();



				if (logger.isDebugEnabled())



					logger.debug("Begin JTATransaction");



			}



			process();



			if (flag) {



				JTA.set(null);



				if (logger.isDebugEnabled())



					logger.debug("Commit JTATransaction Begin");



				if (ROLL.get() == null) {



					tx.commit();



				} else {



					tx.rollback();



				}



				if (logger.isDebugEnabled())



					logger.debug("Commit JTATransaction End");



			}



		} catch (Exception ex) {



			logger.error(ex);



			if (flag) {



				if (tx != null) {



					JTA.set(null);



					try {



						if (logger.isDebugEnabled())



							logger.debug("Rollback JTATransaction Begin");



						tx.rollback();



						if (logger.isDebugEnabled())



							logger.debug("Rollback JTATransaction End");



					} catch (Exception ex1) {



						logger.error(ex1);



					}



				}



			}



			if (ex instanceof RuntimeException)



				throw (RuntimeException) ex;



			throw new RuntimeException(ex);



		}



	}



	public void setRollback() {



		logger.error(getClass().getName() + " is rollbacked");



		ROLL.set(new Boolean(true));

	}



	abstract protected void process();



}