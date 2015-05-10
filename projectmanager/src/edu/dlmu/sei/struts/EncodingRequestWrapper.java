package edu.dlmu.sei.struts;





import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletRequestWrapper;





import org.apache.log4j.Logger;





/**


 * This class functions as a wrapper around HttpServletRequest to provide


 * working getParameter methods for multipart requests. Once Struts requires


 * Servlet 2.3, this class will definately be changed to extend


 * javax.servlet.http.HttpServletRequestWrapper instead of implementing


 * HttpServletRequest. Servlet 2.3 methods are implemented to return


 * <code>null</code> or do nothing if called on. Use


 * {@link #getRequest() getRequest}to retrieve the underlying


 * HttpServletRequest object and call on the 2.3 method there, the empty methods


 * are here only so that this will compile with the Servlet 2.3 jar. This class


 * exists temporarily in the process() method of ActionServlet, just before the


 * ActionForward is processed and just after the Action is performed, the


 * request is set back to the original HttpServletRequest object.


 */


public class EncodingRequestWrapper extends HttpServletRequestWrapper {





	private static Logger logger = Logger.getLogger(EncodingRequestWrapper.class);


	


	/**


	 * @param request


	 */


	public EncodingRequestWrapper(HttpServletRequest request) {


		super(request);


		// TODO Auto-generated constructor stub


	}





	/**


	 * Attempts to get a parameter for this request. It first looks in the


	 * underlying HttpServletRequest object for the parameter, then translate


	 * encoding


	 *  


	 */


	public String getParameter(String name) {


		


		String value = getRequest().getParameter(name);





		logger.debug("getParameter:" + name + ":" + value);





		if (value != null) {


			logger.debug("convertString:" + name + ":" + value);


			value = EncodingTranslate.convertString(value, Encoding.BIG5,


					Encoding.GB2312);


			logger.debug("convertString after:" + name + ":" + value);


		}





		return value;


	}





	/*


	 * (non-Javadoc)


	 * 


	 * @see javax.servlet.ServletRequest#getParameterValues(java.lang.String)


	 */


	public String[] getParameterValues(String name) {


		String[] value = getRequest().getParameterValues(name);





		logger.debug("getParameterValues:" + name + ":" + value);





		if (value != null) {


			for (int i = 0; i < value.length; i++) {


				logger.debug("convertString:" + name + ":" + value[i]);


				value[i] = EncodingTranslate.convertString(value[i],


						Encoding.BIG5, Encoding.GB2312);


				logger.debug("convertString after:" + name + ":" + value[i]);


			}


		}


		return value;


	}





}