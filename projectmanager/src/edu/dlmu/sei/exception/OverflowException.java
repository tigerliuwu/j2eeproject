/*


 * Created on 2004-8-18


 *


 * TODO To change the template for this generated file go to


 * Window - Preferences - Java - Code Style - Code Templates


 */


package edu.dlmu.sei.exception;





/**


 * @author jeff.wen 


 * 


 * TODO To change the template for this generated type comment go to Window -


 * Preferences - Java - Code Style - Code Templates


 */


public class OverflowException extends RunException {





	/**


	 *  


	 */


	public OverflowException() {


		super();


	}





	/**


	 * @param message


	 */


	public OverflowException(String message) {


		super(message);


	}





	/**


	 * @param message


	 * @param cause


	 */


	public OverflowException(String message, Throwable cause) {


		super(message, cause);


	}





	/**


	 * @param cause


	 */


	public OverflowException(Throwable cause) {


		super(cause);


	}


}