package edu.dlmu.sei.bo;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import edu.dlmu.sei.exception.RunException;

/**
 * @author stony.feng
 * 
 */
public class HibernateQueryerHelp {

	/**
	 * 
	 * Comment for <code>logger</code>
	 * 
	 */

	private Logger logger = Logger.getLogger(HibernateQueryerHelp.class);

	/**
	 * 
	 * Comment for <code>criteriaMap</code>
	 * 
	 */

	private Map criteriaMap;

	/**
	 * 
	 * Comment for <code>associationMap</code>
	 * 
	 */

	private Map associationMap;

	/**
	 * 
	 * Comment for <code>fromHql</code>
	 * 
	 */

	private StringBuffer fromHql;

	/**
	 * 
	 * Comment for <code>joinPattern</code>
	 * 
	 */

	private String joinPattern;

	/**
	 * 
	 * Comment for <code>rootKey</code>
	 * 
	 */

	private String rootKey;

	/**
	 * 
	 * Comment for <code>leafProp</code>
	 * 
	 */

	private String leafProp;

	/**
	 * 
	 * Comment for <code>rootProp</code>
	 * 
	 */

	private String rootProp;

	/**
	 * 
	 * 
	 * 
	 */

	public HibernateQueryerHelp() {

	}

	/**
	 * 
	 * @author stony.feng
	 * 
	 * <p/>
	 * 
	 * Preferences - Java - Code Style - Code Templates
	 * 
	 */

	public class Association {

		/**
		 * 
		 * Comment for <code>entityRef</code>
		 * 
		 */

		private String entityRef;

		/**
		 * 
		 * Comment for <code>aliasRef</code>
		 * 
		 */

		private String aliasRef;

		/**
		 * 
		 * @return Returns the aliasRef.
		 * 
		 */

		final public String getAliasRef() {

			return aliasRef;

		}

		/**
		 * 
		 * @param aliasRef
		 *            The aliasRef to set.
		 * 
		 */

		final public void setAliasRef(final String aliasRef) {

			this.aliasRef = aliasRef;

		}

		/**
		 * 
		 * @return Returns the entityRef.
		 * 
		 */

		final public String getEntityRef() {

			return entityRef;

		}

		/**
		 * 
		 * @param entityRef
		 *            The entityRef to set.
		 * 
		 */

		final public void setEntityRef(String entityRef) {

			this.entityRef = entityRef;

		}

	}

	/**
	 * 
	 * @return Returns the associations.
	 * 
	 */

	public Map getAssociations() {

		return associationMap;

	}

	public void init(String rootClassname, Criteria rootCriteria) {

		rootKey = rootClassname;

		if (criteriaMap != null) {

			criteriaMap.clear();

		}

		criteriaMap = new HashMap();

		criteriaMap.put(rootKey, rootCriteria);

	}

	public void init(String rootClassname, String alias, String joinPattern) {

		rootKey = rootClassname;

		Association root = new Association();

		root.setEntityRef(rootClassname);

		root.setAliasRef(alias);

		if (associationMap != null) {

			associationMap.clear();

		}

		associationMap = new HashMap();

		associationMap.put(rootKey, root);

		fromHql = new StringBuffer();

		this.joinPattern = joinPattern;

	}

	public Association setAssociationElement(String parentAlias, String key,

	String entity) {

		Association association = new Association();

		association.setEntityRef(parentAlias + "." + entity);

		association.setAliasRef(parentAlias + "_" + eval(entity));

		associationMap.put(key, association);

		return association;

	}

	private String eval(String property) {

		return property.replace('.', '_');

	}

	public Criteria getRootCriteriaInstance() {

		return (Criteria) criteriaMap.get(rootKey);

	}

	/**
	 * 
	 * @param property
	 *            is
	 * 
	 */

	final public void parse(final String property) {

		String[] props = parseProperty(property);

		rootProp = props[0];

		leafProp = props[1];

	}

	/**
	 * 
	 * @param compProp
	 *            is
	 * 
	 * @return Array
	 * 
	 */

	private String[] parseProperty(final String compProp) {

		String rootkey, leafkey;

		int index = compProp.lastIndexOf('.');

		if (index == -1 || compProp.substring(0, index).equals("comp_id")) {

			rootkey = this.rootKey;

			leafkey = compProp;

		} else {

			rootkey = compProp.substring(0, index);

			leafkey = compProp.substring(index + 1, compProp.length());

		}

		return new String[] { rootkey, leafkey };

	}

	/**
	 * 
	 * @return leafProperty
	 * 
	 */

	final public String getLeafProperty() {

		return leafProp;

	}

	/**
	 * 
	 * @return Criteria
	 * 
	 */

	final public Criteria getCriteriaInstance() {

		Criteria criteria = null;

		try {

			criteria = getCriteriaInstance(rootProp);

		} catch (HibernateException ex) {

			logger.error(ex);

			throw new RunException(ex);

		}

		return criteria;

	}

	/**
	 * 
	 * @param key
	 *            is
	 * 
	 * @return Criteria
	 * 
	 * @throws HibernateException
	 *             is
	 * 
	 */

	private Criteria getCriteriaInstance(final String key)

	throws HibernateException {

		Criteria criteria = (Criteria) criteriaMap.get(key);

		if (criteria != null) {

			return criteria;

		}

		String[] subkeys = parseProperty(key);

		criteria = getCriteriaInstance(subkeys[0]).createCriteria(subkeys[1]);

		criteriaMap.put(key, criteria);

		return criteria;

	}

	/**
	 * 
	 * @return Association
	 * 
	 */

	final public Association getAlias() {

		return getAlias(rootProp);

	}

	/**
	 * 
	 * @param key
	 *            is
	 * 
	 * @return Association
	 * 
	 */

	private Association getAlias(final String key) {

		Association association = (Association) associationMap.get(key);

		if (association != null) {

			return association;

		}

		String[] subkeys = parseProperty(key);

		String parentAlias = getAlias(subkeys[0]).getAliasRef();

		String alias = subkeys[1];

		association = setAssociationElement(parentAlias, key, alias);

		fromHql.append(joinPattern + association.getEntityRef() + " AS "

		+ association.getAliasRef());

		return association;

	}

	/**
	 * 
	 * @return FROM
	 * 
	 */

	final public String getFromHql() {

		return fromHql.toString();

	}

}