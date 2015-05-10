package edu.pm.constants;

public class PMConstants {

	// is_deleted  -------------------------------------------
	
	public static final String DELETED_Y = "1";	// deleted
	
	public static final String DELETED_N = "0";	// not deleted
	
	// is_admin  -------------------------------------------
	
	public static final String ADMIN_Y = "1";	// deleted
	
	public static final String ADMIN_N = "0";	// not deleted
	
	// is_parent  -------------------------------------------
	
	public static final String PARENT_Y = "1";	// is parent
	
	public static final String PARENT_N = "0";	// not parent
	
	// is_working  -------------------------------------------
	
	public static final String WORKING_Y = "1";	// deleted
	
	public static final String WORKING_N = "0";	// not deleted
	
	// accept report result  ---------------------------------
	
	public static final String ACCEPT_Y = "1";	// accept
	
	public static final String ACCEPT_N = "0";	// not accept
	
	// role_id  -------------------------------------------
	
	public static final Long ROLE_PM = new Long(1000);	// pm   项目经理
	
	public static final Long ROLE_SE = new Long(1001);	// se   开发人员
	
	public static final Long ROLE_PORTAL = new Long(999);	// portal  门户用户
	
	public static final Long ROLE_MANAGER = new Long(1002);	// manager 高级经理
	
	
	// ProjectStatus
	public static final String StatusProjectInit = "001"; //初始化
	public static final String StatusProjectGo = "002";//进行中
	public static final String StatusProjectEnd = "003";//已结束
	
	// TargetStatus
	public static final String StatusTargetInit = "001"; //初始化
	public static final String StatusTargetAssign = "002";//已分配
	public static final String StatusTargetEnd = "003";//已完成
	public static final String StatusTargetCancel = "004";//取消
	
	// ProductStatus
	public static final String StatusProductGo = "001"; //开发中
	public static final String StatusProductHandin = "002";//已提交
	public static final String StatusProductPass = "003";//审批通过
	public static final String StatusProductFail = "004";//审批不通过
	
	// ProblemStatus
	public static final String StatusProblemtWait = "001"; //待汇总
	public static final String StatusProblemSum = "002";//已汇总
	public static final String StatusProblemSolve = "003";//解决中
	public static final String StatusProblemClose = "004";//关闭
	public static final String StatusProblemCancle = "005";//取消
	
	// /////////////////////////////////////////////////////////////////////

	// 常量实体类型

	// /////////////////////////////////////////////////////////////////////

	public static final String Users = "Users";
	public static final String Projects = "Projects";
	public static final String Roles = "Roles";
	
	public static final String pubServiceVender = "pubServiceVender";


	
	
}
