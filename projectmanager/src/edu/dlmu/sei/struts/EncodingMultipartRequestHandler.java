package edu.dlmu.sei.struts;





import javax.servlet.http.HttpServletRequest;





import org.apache.commons.fileupload.FileItem;


import org.apache.log4j.Logger;


import org.apache.struts.upload.CommonsMultipartRequestHandler;


import org.apache.struts.upload.MultipartRequestWrapper;





/**


 * @author stony.feng


 * 


 * TODO To change the template for this generated type comment go to Window -


 * Preferences - Java - Code Style - Code Templates


 */


public class EncodingMultipartRequestHandler extends


		CommonsMultipartRequestHandler {





	private static Logger logger = Logger


			.getLogger(EncodingMultipartRequestHandler.class);





	/**


	 * Adds a regular text parameter to the set of text parameters for this


	 * request and also to the list of all parameters. Handles the case of


	 * multiple values for the same parameter by using an array for the


	 * parameter value.


	 * 


	 * @param request


	 *            The request in which the parameter was specified.


	 * @param item


	 *            The file item for the parameter to add.


	 */


	protected void addTextParameter(HttpServletRequest request, FileItem item) {


		String name = item.getFieldName();


		String value = null;





		try {


			value = item.getString("UTF-8");


		} catch (Exception e) {


			value = item.getString();


		}





		logger.debug("convertString");


		value = EncodingTranslate.convertString((String) value, Encoding.BIG5,


				Encoding.GB2312);





		if (request instanceof MultipartRequestWrapper) {


			MultipartRequestWrapper wrapper = (MultipartRequestWrapper) request;


			wrapper.setParameter(name, value);


		}





		String[] oldArray = (String[]) getTextElements().get(name);


		String[] newArray;





		if (oldArray != null) {


			newArray = new String[oldArray.length + 1];


			System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);


			newArray[oldArray.length] = value;


		} else {


			newArray = new String[] { value };


		}





		getTextElements().put(name, newArray);


		getAllElements().put(name, newArray);


	}





}