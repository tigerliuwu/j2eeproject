//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package edu.pm.uc.background.action;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.constants.PMConstants;
import edu.pm.uc.background.form.TreeForm;
import edu.pm.vo.Projects;
import edu.pm.vo.Roles;
import edu.pm.vo.Users;

public class BackTreeAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		Collection nodes = new Vector();
		TreeForm node = null;
		
		// project nodes
		Collection projectList = ConstantsContainer.getInstants().getCollection(PMConstants.Projects);
		if (projectList!=null && projectList.size()>0) {
			Iterator projectIt = projectList.iterator();
			Projects project = null;
			while(projectIt.hasNext()){
				project = (Projects) projectIt.next();
				node = new TreeForm();
				node.setParentid("pro0");
				node.setTreeid("pro_" + project.getId().toString());
				node.setText(project.getProjectName());
				nodes.add(node);
			}
		}
		
		// user nodes
		Collection userList = ConstantsContainer.getInstants().getCollection(PMConstants.Users);
		if (userList!=null && userList.size()>0) {
			Iterator userIt = userList.iterator();
			Users user = null;
			while(userIt.hasNext()) {
				user = (Users) userIt.next();
				node = new TreeForm();
				node.setParentid("use0");
				node.setTreeid("use_" + user.getId().toString());
				node.setText(user.getUserName());
				nodes.add(node);
			}
		}
		
		// role nodes
		Collection roleList = ConstantsContainer.getInstants().getCollection(PMConstants.Roles);
		if (roleList!=null && roleList.size()>0) {
			Iterator roleIt = roleList.iterator();
			Roles role = null;
			while(roleIt.hasNext()){
				role = (Roles) roleIt.next();
				node = new TreeForm();
				node.setParentid("rol0");
				node.setTreeid("rol_" + role.getId().toString());
				node.setText(role.getRemark());
				nodes.add(node);
			}
		}
		request.setAttribute("nodes", nodes);

		return mapping.findForward("success");
	}

}
