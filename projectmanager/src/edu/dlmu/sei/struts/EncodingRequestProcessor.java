package edu.dlmu.sei.struts;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Locale;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import org.apache.struts.Globals;

import org.apache.struts.tiles.TilesRequestProcessor;

/**
 * 
 * 
 * 
 * @author stony.feng
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * TODO To change the template for this generated type comment go to Window -
 * 
 * 
 * 
 * Preferences - Java - Code Style - Code Templates
 * 
 * 
 * 
 */

public class EncodingRequestProcessor extends TilesRequestProcessor {

	private static Logger logger = Logger

	.getLogger(EncodingRequestProcessor.class);

	public void process(HttpServletRequest request, HttpServletResponse response)

	throws IOException, ServletException {

		/*
		 * 
		 * MessageResources resources = (MessageResources) request
		 * 
		 * .getAttribute(Globals.MESSAGES_KEY);
		 * 
		 */

		Locale locale = (Locale) request.getSession().getAttribute(
				Globals.LOCALE_KEY);

		HttpServletRequest requestWrapper = new EncodingRequestWrapper(request);

		if (locale != null && locale == Locale.TRADITIONAL_CHINESE) {

			logger.debug("CharArrayWrapper translate");

	//		System.out.println("CharArrayWrapper translate");

			EncodingResponseWrapper responseWrapper = new EncodingResponseWrapper(

			(HttpServletResponse) response); 

			super.process(requestWrapper, responseWrapper);

			// Turn entire output into one big String.

			String responseString = responseWrapper.toString();

			// In output, replace all occurrences of target string

			// with replacement string.

			responseString = EncodingTranslate.convertString(responseString,

			Encoding.GB2312, Encoding.BIG5);

			PrintWriter out = response.getWriter();

			out.write(responseString);

		} else {

			logger.info("general translate");

			super.process(requestWrapper, response);

		}

	}

}