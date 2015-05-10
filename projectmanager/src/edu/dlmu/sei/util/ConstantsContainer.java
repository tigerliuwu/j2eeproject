package edu.dlmu.sei.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Constants;
import edu.pm.vo.Projects;
import edu.pm.vo.Roles;
import edu.pm.vo.Users;


public class ConstantsContainer {
	
	//examples
	//ConstantsContainer.getInstants().getLabel(PMConstants.Users,userId.toString());
	//ConstantsContainer.getInstants().getVO(PMConstants.Users,userId.toString());
	
	private static ConstantsContainer contantsCache = new ConstantsContainer();

	static {
		contantsCache.init();
	}

	private ConstantsContainer() {

	}

	public static ConstantsContainer getInstants() {
		return contantsCache;
	}

	// 如果一个实体变化了，将会刷新Cache中的实体

	private Map constantsContainer = new HashMap();

	public Collection getCollection(String constantsName) {

		ConstantsItem constants = (ConstantsItem) constantsContainer
				.get(constantsName);

		return constants.getConstants();
	}

	public Object getVO(String constantsName, String constantsId) {

		ConstantsItem constants = (ConstantsItem) constantsContainer
				.get(constantsName);
		// System.out.println(constantsName);

		return constants.get(constantsId);
	}
	
	public void removeVO(String constantsName, String constantsId) {

		ConstantsItem constants = (ConstantsItem) constantsContainer
				.get(constantsName);
		if(constants!=null){
			constants.remove(constantsId);
		}
	}

	public String getLabel(String constantsName, String constantsId) {

		ConstantsItem constants = (ConstantsItem) constantsContainer
				.get(constantsName);

		LabelValue labelValue = (LabelValue) constants.get(constantsId);

		return labelValue.getLabel();
	}

	public void setVO(String constantsName, LabelValue obj) {
		ConstantsItem constants = (ConstantsItem) constantsContainer
				.get(constantsName);
		if(constants!=null){
			constants.set(obj);
		}
		else{
			ConstantsItem aonstants = new ConstantsItem();
			aonstants.add(obj);
			constantsContainer.put(constantsName,aonstants);
		}
		
	}

	public void init() {
		
		// /////////////////////////////////////////////////////////////////////
		// constant entity
		// /////////////////////////////////////////////////////////////////////
		
		// Users
		ConstantsItem userConstants = new ConstantsItem();
		PMBaseQuery userQuery = new PMBaseQuery(Users.class);
		userQuery.execute();
		Iterator userit = userQuery.getResults().iterator();
		while (userit.hasNext()) {
			Users user = (Users) userit.next();
			userConstants.add(user);
		}
		constantsContainer.put(PMConstants.Users,userConstants);
		
		// Projects
		ConstantsItem projectConstants = new ConstantsItem();
		PMBaseQuery projectQuery = new PMBaseQuery(Projects.class);
		projectQuery.execute();
		Iterator projectit = projectQuery.getResults().iterator();
		while (projectit.hasNext()) {
			Projects project = (Projects) projectit.next();
			projectConstants.add(project);
		}
		constantsContainer.put(PMConstants.Projects,projectConstants);
		
		// Roles
		ConstantsItem roleConstants = new ConstantsItem();
		PMBaseQuery roleQuery = new PMBaseQuery(Roles.class);
		roleQuery.execute();
		Iterator roleit = roleQuery.getResults().iterator();
		while (roleit.hasNext()) {
			Roles role = (Roles) roleit.next();
			roleConstants.add(role);
		}
		constantsContainer.put(PMConstants.Roles,roleConstants);

		// constant table
		PMBaseQuery constantQuery = new PMBaseQuery(Constants.class);
		Iterator constantIt = null;
		Constants aConstant = null;
		
		constantQuery.setOrderBy("constantOrder","asc");
		constantQuery.execute();
		
		constantIt = constantQuery.getResults().iterator();
		while (constantIt.hasNext()) {
			aConstant = (Constants) constantIt.next();
			contantsCache.setVO(aConstant.getConstantType(),aConstant);
		}
		
	}// init

}
