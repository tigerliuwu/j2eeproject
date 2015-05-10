package edu.dlmu.sei.exception;

public class ExcelParseException extends RuntimeException {

	/**


	 *  


	 */

	public ExcelParseException() {

		super();

	}

	/**


	 * @param message


	 */

	public ExcelParseException(String message) {

		super(message);

	}

	/**


	 * @param message


	 * @param cause


	 */

	public ExcelParseException(String message, Throwable cause) {

		super(message, cause);

	}

	/**


	 * @param cause


	 */

	public ExcelParseException(Throwable cause) {

		super(cause);

	}

}