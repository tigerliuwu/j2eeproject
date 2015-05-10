/*


 * Created on 2004-6-30


 *


 * To change the template for this generated file go to


 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments


 */


package edu.dlmu.sei.keygenerator;





import java.sql.Connection;


import java.sql.Date;


import java.sql.ResultSet;


import java.sql.Statement;





import org.apache.log4j.Logger;





import edu.dlmu.sei.bo.HibernateBusinessObject;


import edu.dlmu.sei.exception.RunException;





/**


 * @author george.lv


 * 


 * To change the template for this generated type comment go to


 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments


 */


public class OracleSequenceGenerator extends HibernateBusinessObject {





	private static final Logger logger = Logger


			.getLogger(OracleSequenceGenerator.class);





	private String discriminator = "";





	private String sequence = "";





	private String idkey;





	/*


	 * (non-Javadoc)


	 * 


	 * @see com.eapo.common.bo.EAPOBusinessObject#performBusinessLogic()


	 */


	protected void performBusinessLogic() {





		String key = "0000";





		key += nextVal();


		key = key.substring(key.length() - 4);





		Date today = new Date(System.currentTimeMillis());


		key = discriminator + today + key;


		key = key.replaceAll("-", "");





		setIdkey(key);


	}





	public void setDiscriminator(String value) {


		discriminator = value;


	}





	public void setSequenceName(String sequence) {


		this.sequence = sequence;


	}





	/**


	 * @return Returns the idkey.


	 */


	public String getIdkey() {


		return idkey;


	}





	/**


	 * @param idkey


	 *            The idkey to set.


	 */


	public void setIdkey(String idkey) {


		this.idkey = idkey;


	}





	protected int nextVal() {


		try {


			Connection conn = getSession().connection();


			Statement stmt = conn.createStatement();


			String sequenceSQL = "select " + sequence + ".nextval from dual";


			ResultSet res = stmt.executeQuery(sequenceSQL);


			if (res.next()) {


				int result = res.getInt(1);


				res.close();


				stmt.close();





				return result;


			} else {


				res.close();


				stmt.close();


				throw new RunException("generateKey error");


			}


		} catch (Exception e) {


			logger.error(e);


			throw new RunException("generateKey error");


		}


	}





	public String generateKey() {


		execute();


		return getIdkey();


	}





}