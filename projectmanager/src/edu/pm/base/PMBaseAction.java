package edu.pm.base;



import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import org.apache.struts.action.ActionForm;

import org.apache.struts.action.ActionForward;

import org.apache.struts.action.ActionMapping;



import edu.dlmu.sei.bo.HibernateBusinessObject;

import edu.dlmu.sei.struts.action.BaseAction;

import edu.pm.vo.Users;



public abstract class PMBaseAction extends BaseAction {



	protected Users getUser() {



		return (Users) request.getSession().getAttribute("user");



	}
	
	protected Set getPermissionid() {



		return (Set) request.getSession().getAttribute("permissionid");



	}



	protected ActionForward doAction(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {



		HibernateBusinessObject.USER.set(getUser());



		ActionForward forward = doWork(mapping, form, request, response);



		return forward;



	}



	protected abstract ActionForward doWork(ActionMapping mapping,

			ActionForm form, HttpServletRequest request,

			HttpServletResponse response) throws Exception;



}

