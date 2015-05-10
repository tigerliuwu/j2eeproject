package edu.dlmu.sei.dao;



import java.io.Serializable;



import java.util.List;



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



public interface DataAccessObject {



	/**

	 * 

	 * retrieve a persistent instance if you already know its identifier

	 * 

	 * 

	 * 

	 * @param theClass -

	 * 

	 * a persistent class

	 * 

	 * @param id -

	 * 

	 * a valid identifier of an existing persistent instance of the

	 * 

	 * class

	 * 

	 * @return the persistent instance or proxy

	 * 

	 * @throws Exception

	 * 

	 */



	public Object load(Serializable id);



	/**

	 * 

	 * Return the persistent instance of the given entity class with the given

	 * 

	 * identifier, obtaining the specified lock mode, assuming the instance

	 * 

	 * exists.

	 * 

	 * 

	 * 

	 * @param theClass

	 * 

	 * a persistent class

	 * 

	 * @return the persistent instance or proxy

	 * 

	 * @throws HibernateException

	 * 

	 */



	public Object loadAndLock(Serializable id);



	/**

	 * 

	 * Persist the given transient instance

	 * 

	 * 

	 * 

	 * @param object -

	 * 

	 * a transient instance of a persistent class

	 * 

	 * @return the generated identifier

	 * 

	 * @throws Exception

	 * 

	 */



	public Serializable save(Serializable object);



	/**

	 * 

	 * Update the persistent instance with the identifier of the given transient

	 * 

	 * instance

	 * 

	 * 

	 * 

	 * @param object -

	 * 

	 * a transient instance containing updated state

	 * 

	 * @throws Exception

	 * 

	 */



	public void update(Serializable object);



	/**

	 * 

	 * Either save() or update() the given instance, depending upon the value of

	 * 

	 * its identifier property. By default the instance is always saved. This

	 * 

	 * behaviour may be adjusted by specifying an unsaved-value attribute of the

	 * 

	 * identifier property mapping.

	 * 

	 * 

	 * 

	 * @param object -

	 * 

	 * a transient instance containing new or updated state

	 * 

	 * @throws Exception

	 * 

	 */



	public void saveOrUpdate(Serializable object);



	/**

	 * 

	 * Remove a persistent instance from the datastore.

	 * 

	 * 

	 * 

	 * @param object -

	 * 

	 * the instance to be removed

	 * 

	 * @throws Exception

	 * 

	 */



	public void delete(Serializable object);



	/**

	 * 

	 * Batch update or save persistent instances.

	 * 

	 * 

	 * 

	 * @param batch

	 * 

	 * @throws EAPOException

	 * 

	 */



	public void saveOrUpdateBatch(List batch);



}