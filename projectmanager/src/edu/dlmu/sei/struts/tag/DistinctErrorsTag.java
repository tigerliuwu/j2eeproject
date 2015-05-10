/*


 * Created on 2004-7-8


 *


 * TODO To change the template for this generated file go to


 * Window - Preferences - Java - Code Style - Code Templates


 */


package edu.dlmu.sei.struts.tag;





/**


 * @author stony.feng


 *


 * TODO To change the template for this generated type comment go to


 * Window - Preferences - Java - Code Style - Code Templates


 */





import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.jsp.JspException;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.taglib.html.ErrorsTag;
import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;





/**


 * @author Administrator


 * 


 * To change the template for this generated type comment go to Window -


 * Preferences - Java - Code Generation - Code and Comments


 */


public class DistinctErrorsTag extends ErrorsTag{





    // ------------------------------------------------------- Public Methods





    /**


     * Render the specified error messages if there are any.


     * 


     * @exception JspException


     *                         if a JSP exception has occurred


     */


    public int doStartTag() throws JspException {





        // Were any error messages specified?


        ActionErrors errors = null;


        try {


            errors = RequestUtils.getActionErrors(pageContext, name);


        } catch (JspException e) {


            RequestUtils.saveException(pageContext, e);


            throw e;


        }





        if ((errors == null) || errors.isEmpty()) { return (EVAL_BODY_INCLUDE); }





        boolean headerPresent = RequestUtils.present(pageContext, bundle,


                locale, "errors.header");





        boolean footerPresent = RequestUtils.present(pageContext, bundle,


                locale, "errors.footer");





        boolean prefixPresent = RequestUtils.present(pageContext, bundle,


                locale, "errors.prefix");





        boolean suffixPresent = RequestUtils.present(pageContext, bundle,


                locale, "errors.suffix");





        // Render the error messages appropriately


        StringBuffer results = new StringBuffer();


        boolean headerDone = false;


        String message = null;


        Iterator reports = (property == null) ? errors.get() : errors


                .get(property);





        Set distinctReports = new TreeSet();





        while (reports.hasNext()) {


            ActionError report = (ActionError) reports.next();





            message = RequestUtils.message(pageContext, bundle, locale, report


                    .getKey(), report.getValues());





            if (message != null) {


                distinctReports.add(message);


            }





        }





        Iterator distinctIterator = distinctReports.iterator();





        while (distinctIterator.hasNext()) {


            if (!headerDone) {


                if (headerPresent) {


                    message = RequestUtils.message(pageContext, bundle, locale,


                            "errors.header");





                    results.append(message);


                    results.append(lineEnd);


                }


                headerDone = true;


            }





            if (prefixPresent) {


                message = RequestUtils.message(pageContext, bundle, locale,


                        "errors.prefix");


                results.append(message);


            }





            message = (String) distinctIterator.next();





            if (message != null) {


                results.append(message);


                results.append(lineEnd);


            }





            if (suffixPresent) {


                message = RequestUtils.message(pageContext, bundle, locale,


                        "errors.suffix");


                results.append(message);


            }


        }





        if (headerDone && footerPresent) {


            message = RequestUtils.message(pageContext, bundle, locale,


                    "errors.footer");


            results.append(message);


            results.append(lineEnd);


        }





        ResponseUtils.write(pageContext, results.toString());





        return (EVAL_BODY_INCLUDE);





    }


}


