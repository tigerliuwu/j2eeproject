package edu.dlmu.sei.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pm.vo.Constants;

class ConstantsItem {

	private Map Constantsmap = new HashMap();
	
	

	public void add(LabelValue obj) {

		Constantsmap.put(obj.getValue(), obj);
	}
	
	public void remove(String constantsId) {
		if(constantsId!=null && Constantsmap.containsKey(constantsId)){
			Constantsmap.remove(constantsId);
		}
		
	}

	public void set(LabelValue obj) {
		Constantsmap.put(obj.getValue(), obj);
	}

	public Object get(String constantsId) {
		return Constantsmap.get(constantsId);
	}

	public Collection getConstants() {

		List ret = new ArrayList();
		ret.addAll(Constantsmap.values());

		if (Constantsmap.values().size() != 0
				&& Constantsmap.values().iterator().next() instanceof Constants) {
			Collections.sort(ret);
		}

		return ret;
	}

	public Map getConstantsmap() {
		return Constantsmap;
	}

	public void setConstantsmap(Map constantsmap) {
		Constantsmap = constantsmap;
	}

}
