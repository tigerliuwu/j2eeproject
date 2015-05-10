package edu.dlmu.sei.util;



import java.io.Serializable;



/**

 * 

 * @author stony.feng

 * 

 * 

 * 

 * TODO To change the template for this generated type comment go to Window -

 * 

 * Preferences - Java - Code Style - Code Templates

 * 

 */



public class PageRange implements Serializable {



	private int pageSize = 20;



	private int currentPage = 1;



	private int totalResult;



	private int firstResult = -1;



	/**

	 * 

	 * @return Returns the currentPage.

	 * 

	 */



	public int getCurrentPage() {



		return currentPage;



	}



	/**

	 * 

	 * @param currentPage

	 * 

	 * The currentPage to set.

	 * 

	 */



	public void setCurrentPage(int currentPage) {



		if (currentPage == 0)



			this.currentPage = 1;



		else



			this.currentPage = currentPage;



	}



	/**

	 * 

	 * @return Returns the pageSize.

	 * 

	 */



	public int getPageSize() {



		return pageSize;



	}



	/**

	 * 

	 * @param pageSize

	 * 

	 * The pageSize to set.

	 * 

	 */



	public void setPageSize(int pageSize) {



		this.pageSize = pageSize;



	}



	/**

	 * 

	 * @return Returns the totalResult.

	 * 

	 */



	public int getTotalResult() {



		return totalResult;



	}



	/**

	 * 

	 * @param totalResult

	 * 

	 * The totalResult to set.

	 * 

	 */



	public void setTotalResult(int totalResult) {



		this.totalResult = totalResult;



		if (this.currentPage < 0 || this.currentPage > getTotalPage()) {



			this.currentPage = getTotalPage();



		}



	}



	public int getFirstResult() {



		// only for f type cargoplace distribute



		if (firstResult != -1)



			return firstResult;



		return (this.currentPage - 1) * this.pageSize;



	}



	public int getTotalPage() {



		if (this.totalResult == 0)



			return 0;



		if (this.totalResult % this.pageSize == 0)



			return this.totalResult / this.pageSize;



		else



			return this.totalResult / this.pageSize + 1;



	}



	/**

	 * 

	 * get the first record number of the range of records in current page

	 * 

	 * 

	 * 

	 * @return the first record number of the range of records in current page

	 * 

	 */



	public int getFromRow() {



		if (totalResult == 0)



			return 0;



		return getFirstResult() + 1;



	}



	/**

	 * 

	 * get the last record number of the range of records in current page

	 * 

	 * 

	 * 

	 * @return -- the last record number of the range of records in current page

	 * 

	 */



	public int getToRow() {



		return (getFromRow() + pageSize) >= totalResult ? totalResult



		: getFromRow() + pageSize - 1;



	}



	/**

	 * 

	 * get next page num

	 * 

	 * 

	 * 

	 * @return next page number

	 * 

	 */



	public int getNextPage() {



		return currentPage + 1;



	}



	/**

	 * 

	 * get previous page num

	 * 

	 * 

	 * 

	 * @return previous page num

	 * 

	 */



	public int getPreviousPage() {



		return currentPage - 1;



	}



	/**

	 * 

	 * @return Returns the hasNext.

	 * 

	 */



	public boolean getHasNext() {



		return currentPage < getTotalPage();



	}



	/**

	 * 

	 * @return Returns the hasPrevious.

	 * 

	 */



	public boolean getHasPrevious() {



		return currentPage > 1;



	}



	public boolean getHasResults() {



		return this.totalResult > 0;



	}



	/**

	 * 

	 * @param firstResult

	 * 

	 * The firstResult to set.

	 * 

	 */



	public void setFirstResult(int firstResult) {



		this.firstResult = firstResult;



	}



}