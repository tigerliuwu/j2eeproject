package edu.dlmu.sei.bo;

public class InnerJoin {

	private String alias;

	private String property;

	private int depends = -1;

	public InnerJoin(String alias, String property) {
		super();
		this.alias = alias;
		this.property = property;
	}

	public InnerJoin(String alias, String property, int depends) {
		super();
		this.alias = alias;
		this.property = property;
		this.depends = depends;
	}

	public String getJoinSQL(String ref) {
		if (depends == -1)
			return " INNER JOIN " + ref + "." + property + " AS " + alias;
		else
			return " INNER JOIN " + property + " AS " + alias;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public int getDepends() {
		return depends;
	}

	public void setDepends(int depends) {
		this.depends = depends;
	}

}
