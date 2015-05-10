package edu.dlmu.sei.bo;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import java.util.Calendar;

import java.util.Collection;

import java.util.Date;

import java.util.HashMap;

import java.util.Iterator;

import java.util.List;

import java.util.Map;

import org.apache.commons.lang.ObjectUtils;

import org.apache.commons.lang.StringUtils;

import org.apache.commons.lang.time.DateUtils;

import org.apache.log4j.Logger;

import org.hibernate.HibernateException;

import org.hibernate.LockMode;

import org.hibernate.Query;

import edu.dlmu.sei.exception.RunException;

import edu.dlmu.sei.util.CoreUtils;

import edu.dlmu.sei.util.PageRange;

/**
 * 
 * @author stony.feng
 * 
 * 
 * 
 */

public class HibernateQueryObject extends HibernateBusinessObject {

	private static Logger logger = Logger.getLogger(HibernateQueryObject.class);

	private static String SELF_REF = "this";

	// WHERE PATTERN

	private final static int EQ = 1;

	private final static int GE = 2;

	private final static int LE = 3;

	private final static int LIKE = 4;

	private final static int IN = 5;

	private final static int BETWEEN = 6;

	private final static int ORDERASC = 7;

	private final static int ORDERDESC = 8;

	private final static int EXAMPLE = 9;

	private final static int GT = 10;

	private final static int LT = 11;

	private final static int DATEBETWEEN = 12;

	private final static int NOEQ = 13;

	private final static int CMPEQ = 14;

	private final static int CMPNOEQ = 15;

	private final static int CMPGT = 16;

	private final static int BITAND = 17;

	private final static int ISNULL = 18;

	private final static int ISNOTNULL = 19;

	// ORDER PATTERN

	public static final int ORDER_DES = 1;

	public static final int ORDER_ASC = 2;

	// QUREY KEY

	private Map keys = new HashMap();

	private Map orderkeys = new HashMap();

	private Map values1 = new HashMap();

	private Map values2 = new HashMap();

	private Map bundler = new HashMap();

	// ELSE

	private Class clazz;

	private boolean lazy = false;

	private boolean returnCount = false;

	private boolean needDistinct = false;

	private String countHead = "SELECT count(distinct this) FROM ";

	private String queryHead = "SELECT distinct this FROM ";

	private String countHeadNoDistinct = "SELECT count(this) FROM ";

	private String queryHeadNoDistinct = "SELECT this FROM ";

	private StringBuffer wherehql = null;

	private boolean needOrder = true;

	private int orderDirection = 1;

	private PageRange pageRange = null;

	private List results = null;

	private int resultscount = -1;

	public HibernateQueryObject(Class clazz) {

		this.clazz = clazz;

	}

	private String leftJoinFetchs = "";

	private String ordersql = "";

	public void setOrdersql(String ordersql) {

		this.ordersql = ordersql;

	}

	private StringBuffer ordersqlby;

	private void buildOrderClause() {

		ordersqlby = new StringBuffer();

		if (ordersql != null && !ordersql.trim().equals("")) {

			ordersqlby.append(" ORDER BY " + ordersql);

			return;

		}

		if (!needOrder)

			return;

		Map orderkeys = getOrderkeys();

		if (orderkeys.size() == 0) {

			if (orderDirection == ORDER_DES)

				setDESCOrder("id");

			else

				setASCOrder("id");

		}

		Iterator it = orderkeys.keySet().iterator();

		boolean isfirst = true;

		while (it.hasNext()) {

			String key = (String) it.next();

			int condition = ((Integer) orderkeys.get(key)).intValue();

			String property = " this." + key;

			switch (condition) {

			case ORDERASC:

				if (isfirst) {

					isfirst = false;

					ordersqlby.append(" ORDER BY " + property + " ASC ");

				} else {

					ordersqlby.append(" ," + property + " ASC ");

				}

				break;

			case ORDERDESC:

				if (isfirst) {

					isfirst = false;

					ordersqlby.append(" ORDER BY " + property + " DESC ");

				} else {

					ordersqlby.append(" ," + property + " DESC ");

				}

				break;

			default:

				logger.error("Query order no exist");

			}

		}

	}

	private void buildWhereClause() {

		wherehql = new StringBuffer();

		populateWhereHSQL(getKeys(), getValues1(), getValues2());

	}

	private void populateWhereHSQL(Map keys, Map values1, Map values2) {

		if (keys.size() > 0 && wherehql.indexOf(" WHERE ") == -1)

			wherehql.append(" WHERE (1=1) ");

		Iterator it = keys.keySet().iterator();

		while (it.hasNext()) {

			String key = (String) it.next();

			boolean needthis = getFromProperty(key);

			int condition = ((Integer) keys.get(key)).intValue();

			Object obj1 = values1.get(key);

			Object obj2 = values2.get(key);

			String property = needthis ? ("this." + key) : key;

			switch (condition) {

			case CMPEQ:

				needthis = getFromProperty(obj1.toString());

				wherehql.append(" AND " + property + " = "
						+ (needthis ? " this." : "") + obj1);

				break;

			case CMPNOEQ:

				needthis = getFromProperty(obj1.toString());

				wherehql.append(" AND " + property + " != "
						+ (needthis ? " this." : "") + obj1);

				break;

			case CMPGT:

				needthis = getFromProperty(obj1.toString());

				wherehql.append(" AND " + property + " > "
						+ (needthis ? " this." : "") + obj1);

				break;

			case BITAND:

				wherehql.append(" AND BITAND(" + property + " , :"
						+ eval(property) + BITAND + "_0" + " ) = :"
						+ eval(property) + BITAND + "_1");

				bundler.put(eval(property) + BITAND + "_0", obj1);

				bundler.put(eval(property) + BITAND + "_1", obj1);

				break;

			case EQ:

				wherehql.append(" AND " + property + " = :" + eval(property));

				bundler.put(eval(property), obj1);

				break;

			case ISNULL:

				wherehql.append(" AND " + property + " IS NULL ");

				break;

			case ISNOTNULL:

				wherehql.append(" AND " + property + " IS NOT NULL ");

				break;

			case NOEQ:

				wherehql.append(" AND " + property + " != :" + eval(property));

				bundler.put(eval(property), obj1);

				break;

			case GE:

				wherehql.append(" AND " + property + " >= :" + eval(property)
						+ GE);

				bundler.put(eval(property) + GE, obj1);

				break;

			case LE:

				wherehql.append(" AND " + property + " <= :" + eval(property)
						+ LE);

				bundler.put(eval(property) + LE, obj1);

				break;

			case GT:

				wherehql.append(" AND " + property + " > :" + eval(property)
						+ GT);

				bundler.put(eval(property) + GT, obj1);

				break;

			case LT:

				wherehql.append(" AND " + property + " < :" + eval(property)
						+ LT);

				bundler.put(eval(property) + LT, obj1);

				break;

			case LIKE:

				wherehql.append(" AND lower(" + property + ") LIKE :"

				+ eval(property) + LIKE);

				bundler.put(eval(property) + LIKE, obj1);

				break;

			case IN:

				Collection col = (Collection) obj1;

				Iterator init = col.iterator();

				int i = 0;

				wherehql.append(" AND " + property + " IN (");

				while (init.hasNext()) {

					if (i == 0) {

						wherehql.append(":" + eval(property) + IN + i);

					} else {

						wherehql.append(",:" + eval(property) + IN + i);

					}

					bundler.put(eval(property) + IN + i, init.next());

					i++;

				}

				wherehql.append(")");

				break;

			case BETWEEN:

				wherehql.append(

				" AND " + property + " >= :" + eval(property) + BETWEEN

				+ 1).append(

				" AND " + property + " <= :" + eval(property) + BETWEEN

				+ 2);

				bundler.put(eval(property) + BETWEEN + 1, obj1);

				bundler.put(eval(property) + BETWEEN + 2, obj2);

				break;

			case DATEBETWEEN:

				wherehql.append(

				" AND " + property + " >= :" + eval(property) + DATEBETWEEN

				+ 1).append(

				" AND " + property + " < :" + eval(property) + DATEBETWEEN

				+ 2);

				bundler.put(eval(property) + DATEBETWEEN + 1, obj1);

				bundler.put(eval(property) + DATEBETWEEN + 2, obj2);

				break;

			default:

				if (!populateWhereHSQLELSE(condition, property, obj1, obj2,

				wherehql, bundler)) {

					logger.error("Query Condition no exist");

					throw new RunException("Query Condition no exist");

				}

			}

		}

	}

	protected boolean populateWhereHSQLELSE(int condition, String property,
			Object obj1, Object obj2, StringBuffer hql, Map bundler) {
		return false;

	}

	private void bundleCondition(Query query) {

		Iterator it = bundler.keySet().iterator();

		while (it.hasNext()) {

			String property = (String) it.next();

			Object value = bundler.get(property);

			if (value instanceof String) {

				query.setString(property, (String) value);

			} else if (value instanceof Long) {

				query.setLong(property, ((Long) value).longValue());

			} else if (value instanceof Date) {

				query.setDate(property, (Date) value);

			} else if (value instanceof Double) {

				query.setDouble(property, ((Double) value).doubleValue());

			} else if (value instanceof BigDecimal) {

				query.setBigDecimal(property, (BigDecimal) value);

			} else {

				logger.error("Don't support this type:" + value.getClass());

				throw new RunException("Don't support this type:"

				+ value.getClass());

			}

		}

	}

	private String eval(String property) {

		return property.replace('.', '_');

	}

	protected Map getKeys() {

		return keys;

	}

	protected Map getOrderkeys() {

		return orderkeys;

	}

	protected Map getValues1() {

		return values1;

	}

	protected Map getValues2() {

		return values2;

	}

	protected void lazeInit() throws HibernateException {

	}

	protected void performBusinessLogic() throws RunException {

		if (returnCount) {

			execResultsCount();

		} else {

			execResults();

		}

		if (sumcolumn != null) {

			execResultsSum();

		}

	}

	public long getResultsCount() {

		if (resultscount == -1) {

			returnCount = true;

			super.execute();

		}

		return resultscount;

	}

	public List getResults() {

		if (results == null) {

			returnCount = false;

			super.execute();

		}

		return results;

	}

	private boolean checkOutOfMemory = false;

	public void needCheckOutOfMemory() {

		this.checkOutOfMemory = true;

	}

	private void execResults() {

		if (keys.isEmpty() && checkOutOfMemory && pageRange == null) {

			results = new ArrayList();

			logger.error("checkOutOfMemory error:" + getClass().getName());

			return;

		}

		buildWhereClause();

		buildOrderClause();

		try {

			Query query = getSession().createQuery(
					getQueryHead() + getFrom() + leftJoinFetchs
							+ wherehql.toString() + ordersqlby.toString());

			if (lock)

				query.setLockMode(SELF_REF, LockMode.UPGRADE);

			if (logger.isDebugEnabled())

				logger.debug(query.getQueryString());

			bundleCondition(query);

			if (pageRange == null) {

				results = query.list();

			} else {

				Query count = getSession().createQuery(

				getCountHead() + getFrom() + wherehql.toString());

				bundleCondition(count);

				List counts = count.list();

				resultscount = ((Integer) counts.get(0)).intValue();

				pageRange.setTotalResult(resultscount);

				query.setFirstResult(pageRange.getFirstResult());

				query.setMaxResults(pageRange.getPageSize());

				results = query.list();

			}

			if (lazy)

				lazeInit();

		} catch (Exception e) {

			throw new RunException(e);

		}

	}

	private void execResultsCount() {

		try {

			buildWhereClause();

			Query count = getSession().createQuery(

			getCountHead() + getFrom() + wherehql.toString());

			if (logger.isDebugEnabled())

				logger.debug(count.getQueryString());

			bundleCondition(count);

			List counts = count.list();

			resultscount = ((Integer) counts.get(0)).intValue();

		} catch (Exception e) {

			throw new RunException(e);

		}

	}

	private BigDecimal[] returnSum = null;

	private String[] sumcolumn;

	private String sumsql = "";

	public BigDecimal[] getReturnSum() {

		return returnSum;

	}

	public void setSumcolumn(String[] sumcolumn) {

		this.sumcolumn = sumcolumn;

		for (int i = 0; i < sumcolumn.length; i++) {

			if (i == 0)

				sumsql = "sum(that." + sumcolumn[i].trim() + ")";

			else

				sumsql = sumsql + " , sum(that." + sumcolumn[i].trim() + ")";

		}

	}

	private void execResultsSum() {

		try {

			buildWhereClause();

			String sumHead = "SELECT " + sumsql + " FROM " + clazz.getName()

			+ " AS that WHERE that.id IN ( SELECT this.id "

			+ getFrom() + wherehql.toString() + ")";

			Query count = getSession().createQuery(sumHead);

			if (logger.isDebugEnabled())

				logger.debug(count.getQueryString());

			bundleCondition(count);

			List counts = count.list();

			returnSum = new BigDecimal[sumcolumn.length];

			if (sumcolumn.length == 1) {

				returnSum[0] = (BigDecimal) counts.get(0);

			} else {

				Object[] ret = (Object[]) counts.get(0);

				for (int i = 0; i < ret.length; i++) {

					returnSum[i] = (BigDecimal) ret[i];

				}

			}

		} catch (Exception e) {

			throw new RunException(e);

		}

	}

	protected void setASCOrder(String property) {

		if (StringUtils.isNotBlank(property))

			orderkeys.put(property, new Integer(ORDERASC));

	}

	protected void setDESCOrder(String property) {

		if (StringUtils.isNotBlank(property))

			orderkeys.put(property, new Integer(ORDERDESC));

	}

	protected void buildBetweenCondition(String property, Object begin,

	Object end) {

		if (begin != null) {

			if (end == null) {

				setGECondition(property, begin);

			} else {

				setBETWEENCondition(property, begin, end);

			}

		} else {

			if (end != null)

				setLECondition(property, end);

		}

	}

	protected void buildDateCondition(String property, Date dateBegin,
			Date dateEnd) {

		if (dateBegin != null) {

			if (dateEnd == null) {

				setGECondition(property, DateUtils.truncate(dateBegin,

				Calendar.DAY_OF_MONTH));

			} else {

				setDATEBETWEENCondition(property, DateUtils.truncate(dateBegin,

				Calendar.DAY_OF_MONTH), CoreUtils.nextDate(DateUtils

				.truncate(dateEnd, Calendar.DAY_OF_MONTH)));

			}

		} else {

			if (dateEnd != null)

				setLTCondition(property, CoreUtils.nextDate(DateUtils.truncate(

				dateEnd, Calendar.DAY_OF_MONTH)));

		}

	}

	protected void buildDateCondition(String property, String val1, String val2) {

		buildDateCondition(property, CoreUtils.parseDate(val1), CoreUtils
				.parseDate(val2));

	}

	protected void setBETWEENCondition(String property, Object object1,
			Object object2) {

		if ((object1 != null && object1 instanceof Date)
				|| (object2 != null && object2 instanceof Date))
			throw new RunException(" You need use buildDateCondition. ");

		keys.put(property, new Integer(BETWEEN));

		values1.put(property, object1);

		values2.put(property, object2);

	}

	protected void setDATEBETWEENCondition(String property, Object object1,
			Object object2) {

		keys.put(property, new Integer(DATEBETWEEN));

		values1.put(property, object1);

		values2.put(property, object2);

	}

	protected void setBITANDCondition(String property, Object object) {

		if (StringUtils.isBlank(ObjectUtils.defaultIfNull(object, "")
				.toString()))
			return;

		if (!StringUtils.isNumeric(ObjectUtils.defaultIfNull(object, "")
				.toString()))
			return;

		keys.put(property, new Integer(BITAND));

		values1.put(property, object);

	}

	protected void setEQCondition(String property, Object object) {

		if (StringUtils.isBlank(ObjectUtils.defaultIfNull(object, "")

		.toString()))

			return;

		keys.put(property, new Integer(EQ));

		values1.put(property, object);

	}

	protected void setISNULLCondition(String property) {

		keys.put(property, new Integer(ISNULL));

	}

	protected void setISNOTNULLCondition(String property) {

		keys.put(property, new Integer(ISNOTNULL));

	}

	protected void setNOEQCondition(String property, Object object) {

		if (StringUtils.isBlank(ObjectUtils.defaultIfNull(object, "")

		.toString()))

			return;

		keys.put(property, new Integer(NOEQ));

		values1.put(property, object);

	}

	protected void setEQConditionAllowNull(String property, Object object) {

		keys.put(property, new Integer(EQ));

		values1.put(property, object);

	}

	protected void setCMPEQCondition(String property1, String property2) {

		keys.put(property1, new Integer(CMPEQ));

		values1.put(property1, property2);

	}

	protected void setCMPGTCondition(String property1, String property2) {

		keys.put(property1, new Integer(CMPGT));

		values1.put(property1, property2);

	}

	protected void setCMPNOEQCondition(String property1, String property2) {

		keys.put(property1, new Integer(CMPNOEQ));

		values1.put(property1, property2);

	}

	protected void setExample(String property, Object object) {

		if (StringUtils.isBlank(ObjectUtils.defaultIfNull(object, "")

		.toString()))

			return;

		keys.put(property, new Integer(EXAMPLE));

		values1.put(property, object);

	}

	protected void setGECondition(String property, Object object) {

		if (StringUtils.isBlank(ObjectUtils.defaultIfNull(object, "")

		.toString()))

			return;

		keys.put(property, new Integer(GE));

		values1.put(property, object);

	}

	protected void setGTCondition(String property, Object object) {

		if (StringUtils.isBlank(ObjectUtils.defaultIfNull(object, "")

		.toString()))

			return;

		keys.put(property, new Integer(GT));

		values1.put(property, object);

	}

	protected void setINCondition(String property, Collection object) {

		if (object == null || object.size() == 0)

			return;

		keys.put(property, new Integer(IN));

		values1.put(property, object);

	}

	protected void setINCondition(String property, String[] objects) {

		Collection col = new ArrayList();

		for (int i = 0; i < objects.length; i++) {

			if (objects[i] != null && !objects[i].trim().equals(""))

				col.add(objects[i]);

		}

		if (!col.isEmpty())

			setINCondition(property, col);

	}

	protected void setLECondition(String property, Object object) {

		if (StringUtils.isBlank(ObjectUtils.defaultIfNull(object, "")

		.toString()))

			return;

		keys.put(property, new Integer(LE));

		values1.put(property, object);

	}

	protected void setLTCondition(String property, Object object) {

		if (StringUtils.isBlank(ObjectUtils.defaultIfNull(object, "")

		.toString()))

			return;

		keys.put(property, new Integer(LT));

		values1.put(property, object);

	}

	protected void setLIKECondition(String property, Object object) {

		if (StringUtils.isBlank(ObjectUtils.defaultIfNull(object, "")
				.toString()))

			return;

		if (object.toString().equals("%null%")
				|| object.toString().equals("%%")
				|| object.toString().equals("%"))

			return;

		String str = object.toString().toLowerCase();

		keys.put(property, new Integer(LIKE));

		values1.put(property, str);

	}

	public void setNeedOrder(boolean needOrder) {

		this.needOrder = needOrder;

	}

	protected void setCountHead(String countHead) {

		if (needDistinct)

			this.countHead = countHead;

		else

			this.countHeadNoDistinct = countHead;

	}

	public void setPageRange(PageRange pageRange) {

		this.pageRange = pageRange;

	}

	public void setOrderDirection(int orderDirection) {

		this.orderDirection = orderDirection;

	}

	public void setLazy(boolean lazy) {

		this.lazy = lazy;

	}

	private boolean lock = false;

	public void lock() {

		this.lock = true;

	}

	public void unLock() {

		this.lock = false;

	}

	public String getCountHead() {

		if (needDistinct)

			return countHead;

		else

			return countHeadNoDistinct;

	}

	public String getQueryHead() {

		if (needDistinct)

			return queryHead;

		else

			return queryHeadNoDistinct;

	}

	public void setLeftJoinFetchs(String leftJoinFetchs) {
		this.leftJoinFetchs = leftJoinFetchs;
	}

	private String getFrom() {
		String innerjoinSQL = "";

		Iterator it = needInnerJoinNo.iterator();

		while (it.hasNext()) {
			Integer key = (Integer) it.next();
			InnerJoin innerJoin = (InnerJoin) innerJoins.get(key);
			innerjoinSQL += innerJoin.getJoinSQL(SELF_REF);
		}

		return clazz.getName() + " AS " + SELF_REF + innerjoinSQL;
	}

	private Map innerJoins = new HashMap();

	private Map innerJoinsAlias = new HashMap();

	protected void addInnerJoin(int no, String alias, String property) {
		innerJoins.put(new Integer(no), new InnerJoin(alias, property));
		innerJoinsAlias.put(alias, new Integer(no));
	}

	protected void addInnerJoin(int no, String alias, String property,
			int depends) {
		innerJoins
				.put(new Integer(no), new InnerJoin(alias, property, depends));
		innerJoinsAlias.put(alias, new Integer(no));
	}

	private Set needInnerJoinNo = new TreeSet();

	private boolean getFromProperty(String property) {

		if (innerJoins.size() == 0)
			return true;

		int index = property.indexOf(".");

		if (index == -1)
			return true;

		String alias = property.substring(0, index);

		Object obj = innerJoinsAlias.get(alias);

		if (obj != null) {
			needInnerJoinNo.add((Integer) obj);

			InnerJoin join = (InnerJoin) innerJoins.get((Integer) obj);

			if (join.getDepends() != -1)
				needInnerJoinNo.add(new Integer(join.getDepends()));
			else {
				this.needDistinct = true;
				return false;
			}

			join = (InnerJoin) innerJoins.get(new Integer(join.getDepends()));

			if (join.getDepends() != -1)
				needInnerJoinNo.add(new Integer(join.getDepends()));
			else
				return false;

			join = (InnerJoin) innerJoins.get(new Integer(join.getDepends()));

			if (join.getDepends() != -1)
				needInnerJoinNo.add(new Integer(join.getDepends()));
			else
				return false;

			join = (InnerJoin) innerJoins.get(new Integer(join.getDepends()));

			if (join.getDepends() != -1)
				needInnerJoinNo.add(new Integer(join.getDepends()));
			else
				return false;

			this.needDistinct = true;
			return false;

		}

		return true;

	}

}