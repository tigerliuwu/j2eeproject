/*


 * Created on 2004-7-12


 *


 * TODO To change the template for this generated file go to


 * Window - Preferences - Java - Code Style - Code Templates


 */


package edu.dlmu.sei.exception;





/**


 * @author stony.feng


 * 


 * TODO To change the template for this generated type comment go to Window -


 * Preferences - Java - Code Style - Code Templates


 */


public class HttpSessionException extends RuntimeException {





	/**


	 *  


	 */


	public HttpSessionException() {


		super();


	}





	/**


	 * @param message


	 */


	public HttpSessionException(String message) {


		super(message);


	}





	/**


	 * @param message


	 * @param cause


	 */


	public HttpSessionException(String message, Throwable cause) {


		super(message, cause);


	}





	/**


	 * @param cause


	 */


	public HttpSessionException(Throwable cause) {


		super(cause);


	}


}