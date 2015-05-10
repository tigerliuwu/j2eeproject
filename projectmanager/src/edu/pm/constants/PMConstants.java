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
	
	public static final Long ROLE_PM = new Long(1000);	// pm   ��Ŀ����
	
	public static final Long ROLE_SE = new Long(1001);	// se   ������Ա
	
	public static final Long ROLE_PORTAL = new Long(999);	// portal  �Ż��û�
	
	public static final Long ROLE_MANAGER = new Long(1002);	// manager �߼�����
	
	
	// ProjectStatus
	public static final String StatusProjectInit = "001"; //��ʼ��
	public static final String StatusProjectGo = "002";//������
	public static final String StatusProjectEnd = "003";//�ѽ���
	
	// TargetStatus
	public static final String StatusTargetInit = "001"; //��ʼ��
	public static final String StatusTargetAssign = "002";//�ѷ���
	public static final String StatusTargetEnd = "003";//�����
	public static final String StatusTargetCancel = "004";//ȡ��
	
	// ProductStatus
	public static final String StatusProductGo = "001"; //������
	public static final String StatusProductHandin = "002";//���ύ
	public static final String StatusProductPass = "003";//����ͨ��
	public static final String StatusProductFail = "004";//������ͨ��
	
	// ProblemStatus
	public static final String StatusProblemtWait = "001"; //������
	public static final String StatusProblemSum = "002";//�ѻ���
	public static final String StatusProblemSolve = "003";//�����
	public static final String StatusProblemClose = "004";//�ر�
	public static final String StatusProblemCancle = "005";//ȡ��
	
	// /////////////////////////////////////////////////////////////////////

	// ����ʵ������

	// /////////////////////////////////////////////////////////////////////

	public static final String Users = "Users";
	public static final String Projects = "Projects";
	public static final String Roles = "Roles";
	
	public static final String pubServiceVender = "pubServiceVender";


	
	
}
