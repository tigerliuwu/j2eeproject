package edu.dlmu.sei.struts;





/**


 * @author stony.feng


 *


 * TODO To change the template for this generated type comment go to


 * Window - Preferences - Java - Code Style - Code Templates


 */


import java.io.ByteArrayOutputStream;


import java.io.IOException;


import java.io.UnsupportedEncodingException;





import javax.servlet.ServletOutputStream;


import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpServletResponseWrapper;





/**


 * A response wrapper that takes everything the client would normally output and


 * saves it in one big character array.


 */





public class EncodingResponseWrapper extends HttpServletResponseWrapper {


	private ByteArrayOutputStream buffer;





	/**


	 * Initializes wrapper.


	 * <P>


	 * First, this constructor calls the parent constructor. That call is


	 * crucial so that the response is stored and thus setHeader, setStatus,


	 * addCookie, and so forth work normally.


	 * <P>


	 * Second, this constructor creates a CharArrayWriter that will be used to


	 * accumulate the response.


	 */





	public EncodingResponseWrapper(HttpServletResponse response) {


		super(response);


		buffer = new ByteArrayOutputStream();


	}





	/**


	 * Get a String representation of the entire buffer.


	 * <P>


	 * Be sure <B>not </B> to call this method multiple times on the same


	 * wrapper. The API for CharArrayWriter does not guarantee that it


	 * "remembers" the previous value, so the call is likely to make a new


	 * String every time.


	 */





	public String toString() {


		String str = null;





		try {


			str = (buffer.toString("utf-8"));


		} catch (UnsupportedEncodingException e) {


			// TODO Auto-generated catch block


			e.printStackTrace();


		}


		return str;


	}





	/*


	 * (non-Javadoc)


	 * 


	 * @see javax.servlet.ServletResponse#getOutputStream()


	 */


	public ServletOutputStream getOutputStream() throws IOException {


		return new EncodingServletOutputStream(buffer);


	}





	class EncodingServletOutputStream extends ServletOutputStream {


		ByteArrayOutputStream buffer;





		public EncodingServletOutputStream(ByteArrayOutputStream outputStream) {


			super();


			buffer = outputStream;


		}





		/*


		 * (non-Javadoc)


		 * 


		 * @see java.io.OutputStream#write(int)


		 */


		public void write(int aInt) {


			buffer.write(aInt);


		}





		/*


		 * (non-Javadoc)


		 * 


		 * @see java.io.OutputStream#write(byte[], int, int)


		 */


		public void write(byte[] b, int off, int len) throws IOException {


			// TODO Auto-generated method stub


			buffer.write(b, off, len);


		}


	}


}