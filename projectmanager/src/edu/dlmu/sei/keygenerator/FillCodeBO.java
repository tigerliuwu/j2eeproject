package edu.dlmu.sei.keygenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import edu.pm.base.PMBaseBusinessObject;

public class FillCodeBO extends PMBaseBusinessObject {

	private Logger logger = Logger.getLogger(FillCodeBO.class);
	private String tableName;
	private String columnName;
	private String head;
	private int numCount;
	private String lockString;
	private String idName;
	private Long id;


	/**
	 * 
	 * update the code column fit to your pattern  
	 * 
	 * @param tableName -
	 * 
	 * 表名
	 * 
	 * @param columnName -
	 * 
	 * code 对应 字段名
	 * 
	 * @param head -
	 * 
	 * 缺少最后流水号的 code 前端
	 * 
	 * @param numCount -
	 * 
	 * 最后流水号数字的个数
	 * 
	 * @param lockString -
	 * 
	 * 对应于 PUB_LOCK表中的字符串名
	 * 
	 * @param idName -
	 * 
	 * 表中主键的字段名
	 * 
	 * @param id -
	 * 
	 * 对应记录的 id 值
	 * 
	 */
	
	//	example
	//FillCodeBO bo= new FillCodeBO("IMP_certificatebattery","certificatebatteryno","BA4700606",4,"TE","certificatebatteryid",new Long(142));
	
	
	public FillCodeBO(String tableName,String columnName,String head,int numCount,String lockString,String idName,Long id) {
		super();
		
		this.tableName=tableName;
		this.columnName=columnName;
		this.head=head;
		this.numCount=numCount;
		this.lockString=lockString;
		this.idName=idName;
		this.id=id;
		
	}
	
	private String computeNewCode(String maxCode,String head,int numCount){
		
		String newCode="";
		if(maxCode!=null){
			int i=head.length();
			int j=maxCode.length();
			int k=j-i;
			
			String numPart=maxCode.substring(i,j);
			int theInt= new Integer(numPart).intValue();
			theInt++;
			String numString =new Integer(theInt).toString();
			k=k-numString.length();
			String temp0="";
			for(;k>0;k--){
				temp0=temp0+"0";
			}
			numString=temp0+numString;
			newCode=head+numString;
		}
		else{
			String temp0="";
			for(int k=numCount-1;k>0;k--){
				temp0=temp0+"0";
			}
			newCode=head+temp0+"1";
		}
		
		return newCode;
	}

	/* 
		select nn from(
		select rownum mm, nn from(
		select to_number(substr(certificatebatteryno, length('BA4700606') + 1)) nn
		from IMP_certificatebattery where certificatebatteryno like('BA4700606%')
		order by nn )) where mm != nn and rownum = 1
	 */
	protected void performBusinessLogic() {

		String sql1 = " SELECT * FROM " + "PUB_LOCK";
		sql1 = sql1+" WHERE " + "LockType" + " LIKE '" + lockString.trim() + "' FOR UPDATE";

		String sql2 = " SELECT MAX(" + columnName+ ") AS A FROM "+ tableName ;
		sql2 = sql2+" WHERE " + columnName + " LIKE '" + head.trim() + "%' ";
		
		
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		Statement stmt = null;

		ResultSet rset1 = null;
		
		String maxCode="";
		String newCode="";
		
		try {

			Connection conn = getSession().connection();

			pstm1 = conn.prepareStatement(sql1);
			
			pstm1.executeQuery();
			
			pstm2 = conn.prepareStatement(sql2);
			
			rset1 = pstm2.executeQuery();
			
			rset1.next();
			
			maxCode=rset1.getString("A");
			
			newCode=computeNewCode(maxCode,head,numCount);
			
			String sql3 = " UPDATE " + tableName+ " SET "+ columnName + " = '" + newCode +"' " ;
			sql3=sql3+" WHERE " + idName + " = " + id;
			
			logger.info(sql3);

			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql3);
			

		}  catch (Exception e) {

			System.out.println(e);
			e.printStackTrace();

		}
		finally{
			try {
				if (rset1 != null)
					rset1.close();
			} catch (SQLException e1) {
			}

			try {
				if (pstm1 != null)
					pstm1.close();
				if (pstm2 != null)
					pstm2.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e1) {
			}
		}

	}

}
