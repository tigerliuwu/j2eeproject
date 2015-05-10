package edu.dlmu.sei.util;

import edu.pm.base.PMBaseBusinessObject;
//import edu.pm.vo.PubPermissionset;

public class FillPermissionsetBO extends PMBaseBusinessObject {


	public FillPermissionsetBO() {
		super();
	}

	protected void performBusinessLogic() {
/*
		String sqls = "SELECT permissionsetid, permissionid FROM permissionrelation";

		PreparedStatement pstm = null;

		ResultSet rset = null;
		
		PubPermissionset permissionset=null;

		try {

			Connection conn = getSession().connection();

			pstm = conn.prepareStatement(sqls);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Long psetid=new Long(rset.getLong("permissionsetid"));
				Long pid=new Long(rset.getLong("permissionid"));
				
				permissionset=(PubPermissionset) ConstantsContainer.getInstants().getVO("pubPermissionset", psetid.toString());
				permissionset.addPermission(pid);
			}

		} catch (Exception e) {

			System.out.println(e);

		}
		finally{
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
*/
	}

}
