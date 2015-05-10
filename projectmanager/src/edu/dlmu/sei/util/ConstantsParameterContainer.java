package edu.dlmu.sei.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.dlmu.sei.bo.HibernateBusinessObject;
import edu.dlmu.sei.exception.RunException;
import edu.pm.constants.PMConstants;

public class ConstantsParameterContainer extends HibernateBusinessObject {

	private ConstantsContainer instance = ConstantsContainer.getInstants();

	private String labelvalue;

	private String parameter1;

	private String parameter2;

	private List results = new ArrayList();

	public List getResults() {
		return results;
	}

	public ConstantsParameterContainer(String labelvalue, String parameter1,
			String parameter2) {
		super();
		this.labelvalue = labelvalue;
		this.parameter1 = parameter1;
		this.parameter2 = parameter2;
	}

	protected void performBusinessLogic() {

		if (PMConstants.pubServiceVender.equals(labelvalue))
			getServiceVendor();
		


	}

	private void getServiceVendor() {

		PreparedStatement pstm = null;

		ResultSet rset = null;

		String sql = null;
		sql = "select servicevenderid from pub_servicevender "
				+ "WHERE BITAND (servicetype, ?) = ? ORDER BY servicevendercode";

		try {

			Connection conn = getSession().connection();

			pstm = conn.prepareStatement(sql);

			pstm.setLong(1, Long.parseLong(parameter1));
			pstm.setLong(2, Long.parseLong(parameter1));

			rset = pstm.executeQuery();

			while (rset.next()) {

				results.add(instance.getVO(PMConstants.pubServiceVender,rset.getLong(1) + ""));

			}

		} catch (SQLException e) {

			throw new RunException(e);

		} finally {

			try {
				if (rset != null)
					rset.close();
			} catch (SQLException e1) {
			}

			try {
				if (pstm != null)
					pstm.close();
			} catch (SQLException e1) {
			}

		}
	}
	

}