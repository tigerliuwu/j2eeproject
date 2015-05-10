/*


 * Created on 2004-7-11


 *


 * TODO To change the template for this generated file go to


 * Window - Preferences - Java - Code Style - Code Templates


 */


package edu.dlmu.sei.struts.tag;





import java.lang.reflect.Array;


import java.util.ArrayList;


import java.util.Arrays;


import java.util.Collection;


import java.util.Enumeration;


import java.util.Iterator;


import java.util.Map;





import javax.servlet.jsp.JspException;


import javax.servlet.jsp.tagext.BodyTagSupport;





import org.apache.commons.collections.IteratorUtils;


import org.apache.struts.util.MessageResources;


import org.apache.struts.util.RequestUtils;


import org.apache.struts.util.ResponseUtils;





/**


 * @author stony.feng


 * 


 * TODO To change the template for this generated type comment go to Window -


 * Preferences - Java - Code Style - Code Templates


 */


public class IterateMutiTag extends BodyTagSupport {





    // ----------------------------------------------------- Instance Variables





    /**


     * Iterator of the elements of this collection, while we are actually


     * running.


     */


    private Iterator iterator = null;





    /**


     * The number of elements we have already rendered.


     */


    private int lengthCount = 0;





    /**


     * The actual length value (calculated in the start tag).


     */


    private int lengthValue = 0;





    /**


     * The space length value (calculated in the start tag).


     */


    private int spaceValue = 0;





    /**


     * The message resources for this package.


     */


    private static MessageResources messages = MessageResources


            .getMessageResources("org.apache.struts.taglib.logic.LocalStrings");





    /**


     * The actual offset value (calculated in the start tag).


     */


    private int offsetValue = 0;





    /**


     * Has this tag instance been started?


     */


    private boolean started = false;





    // ------------------------------------------------------------- Properties





    /**


     * The collection over which we will be iterating.


     */


    private Object collection = null;





    /**


     * @return Collection


     */


    final public Object getCollection() {


        return (this.collection);


    }





    /**


     * @param collection


     *            is


     */


    final public void setCollection(final Object collection) {


        this.collection = collection;


    }





    /**


     * The name of the scripting variable to be exposed.


     */


    private String id = null;





    /**


     * (non-Javadoc)


     * 


     * @see javax.servlet.jsp.tagext.TagSupport#getId()


     */


    public String getId() {


        return (this.id);


    }





    /**


     * (non-Javadoc)


     * 


     * @see javax.servlet.jsp.tagext.TagSupport#setId(java.lang.String)


     */


    public void setId(String id) {


        this.id = id;


    }





    /**


     * <p>


     * Return the zero-relative index of the current iteration through the loop.


     * If you specify an <code>offset</code>, the first iteration through the


     * loop will have that value; otherwise, the first iteration will return


     * zero.


     * </p>


     * 


     * <p>


     * This property is read-only, and gives nested custom tags access to this


     * information. Therefore, it is <strong>only </strong> valid in between


     * calls to <code>doStartTag()</code> and <code>doEndTag()</code>.


     * </p>


     */


    public int getIndex() {


        if (started)


            return (offsetValue + lengthCount - 1);


        else


            return (0);


    }





    /**


     * The name of the scripting variable to be exposed as the current index.


     */


    protected String indexId = null;





    public String getIndexId() {


        return (this.indexId);


    }





    public void setIndexId(String indexId) {


        this.indexId = indexId;


    }





    /**


     * The name of the scripting variable to be exposed as the current index.


     */


    protected String rowId = null;





    public String getRowId() {


        return (this.rowId);


    }





    public void setRowId(String rowId) {


        this.rowId = rowId;


    }





    /**


     * The length value or attribute name ( <=0 means no limit).


     */


    protected String length = null;





    public String getLength() {


        return (this.length);


    }





    public void setLength(String length) {


        this.length = length;


    }





    /**


     * The name of the collection or owning bean.


     */


    protected String name = null;





    public String getName() {


        return (this.name);


    }





    public void setName(String name) {


        this.name = name;


    }





    /**


     * The starting offset (zero relative).


     */


    protected String offset = null;





    public String getOffset() {


        return (this.offset);


    }





    public void setOffset(String offset) {


        this.offset = offset;


    }





    /**


     * The space value or attribute name ( <=0 means 1).


     */


    protected String space = null;





    public String getSpace() {


        return (this.space);


    }





    public void setSpace(String space) {


        this.space = space;


    }





    /**


     * The property name containing the collection.


     */


    protected String property = null;





    public String getProperty() {


        return (this.property);


    }





    public void setProperty(String property) {


        this.property = property;


    }





    /**


     * The scope of the bean specified by the name property, if any.


     */


    protected String scope = null;





    public String getScope() {


        return (this.scope);


    }





    public void setScope(String scope) {


        this.scope = scope;


    }





    /**


     * The Java class of each exposed element of the collection.


     */


    protected String type = null;





    public String getType() {


        return (this.type);


    }





    public void setType(String type) {


        this.type = type;


    }





    // --------------------------------------------------------- Public Methods





    /**


     * Construct an iterator for the specified collection, and begin looping


     * through the body once per element.


     * 


     * @exception JspException


     *                if a JSP exception has occurred


     */


    public int doStartTag() throws JspException {





        // Acquire the collection we are going to iterate over


        Object collection = this.collection;


        if (collection == null) {


            collection = RequestUtils


                    .lookup(pageContext, name, property, scope);


        }





        if (collection == null) {


            JspException e = new JspException(messages


                    .getMessage("iterate.collection"));


            RequestUtils.saveException(pageContext, e);


            throw e;


        }





        // Construct an iterator for this collection


        if (collection.getClass().isArray()) {


            try {


                // If we're lucky, it is an array of objects


                // that we can iterate over with no copying


                iterator = Arrays.asList((Object[]) collection).iterator();


            } catch (ClassCastException e) {


                // Rats -- it is an array of primitives


                int length = Array.getLength(collection);


                ArrayList c = new ArrayList(length);


                for (int i = 0; i < length; i++) {


                    c.add(Array.get(collection, i));


                }


                iterator = c.iterator();


            }


        } else if (collection instanceof Collection) {


            iterator = ((Collection) collection).iterator();


        } else if (collection instanceof Iterator) {


            iterator = (Iterator) collection;


        } else if (collection instanceof Map) {


            iterator = ((Map) collection).entrySet().iterator();


        } else if (collection instanceof Enumeration) {


            iterator = IteratorUtils.asIterator((Enumeration) collection);


        } else {


            JspException e = new JspException(messages


                    .getMessage("iterate.iterator"));


            RequestUtils.saveException(pageContext, e);


            throw e;


        }





        // Calculate the starting offset


        if (offset == null) {


            offsetValue = 0;


        } else {


            try {


                offsetValue = Integer.parseInt(offset);


            } catch (NumberFormatException e) {


                Integer offsetObject = (Integer) RequestUtils.lookup(


                        pageContext, offset, null);


                if (offsetObject == null) {


                    offsetValue = 0;


                } else {


                    offsetValue = offsetObject.intValue();


                }


            }


        }


        if (offsetValue < 0) {


            offsetValue = 0;


        }





        // Calculate the rendering length


        if (length == null) {


            lengthValue = 0;


        } else {


            try {


                lengthValue = Integer.parseInt(length);


            } catch (NumberFormatException e) {


                Integer lengthObject = (Integer) RequestUtils.lookup(


                        pageContext, length, null);


                if (lengthObject == null) {


                    lengthValue = 0;


                } else {


                    lengthValue = lengthObject.intValue();


                }


            }


        }


        if (lengthValue < 0) {


            lengthValue = 0;


        }


        lengthCount = 0;





        // Calculate the rendering space


        if (space == null) {


            spaceValue = 0;


        } else {


            try {


                spaceValue = Integer.parseInt(space);


            } catch (NumberFormatException e) {


                Integer spaceObject = (Integer) RequestUtils.lookup(


                        pageContext, space, null);


                if (spaceObject == null) {


                    spaceValue = 0;


                } else {


                    spaceValue = spaceObject.intValue();


                }


            }


        }


        if (spaceValue < 0) {


            spaceValue = 0;


        }





        // Skip the leading elements up to the starting offset


        for (int i = 0; i < offsetValue * spaceValue; i++) {


            if (iterator.hasNext()) {


                iterator.next();


            }


        }





        // Store the first value and evaluate, or skip the body if none


        if (iterator.hasNext()) {





            ArrayList elements = new ArrayList();





            for (int i = 0; i < spaceValue; i++) {


                if (iterator.hasNext()) {


                    elements.add(iterator.next());


                }


            }





            pageContext.setAttribute(id, elements);


            lengthCount++;


            started = true;





            if (indexId != null) {


                pageContext.setAttribute(indexId, new Integer(getIndex()));


            }





            return (EVAL_BODY_INCLUDE);


        } else {


            return (SKIP_BODY);


        }





    }





    /**


     * Make the next collection element available and loop, or finish the


     * iterations if there are no more elements.


     * 


     * @exception JspException


     *                if a JSP exception has occurred


     */


    public int doAfterBody() throws JspException {





        // Render the output from this iteration to the output stream


        if (bodyContent != null) {


            ResponseUtils.writePrevious(pageContext, bodyContent.getString());


            bodyContent.clearBody();


        }





        // Decide whether to iterate or quit


        if ((lengthValue > 0) && (lengthCount >= lengthValue)) {


            return (SKIP_BODY);


        }





        if (iterator.hasNext()) {





            ArrayList elements = new ArrayList();





            for (int i = 0; i < spaceValue; i++) {


                if (iterator.hasNext()) {


                    elements.add(iterator.next());


                }


            }





            pageContext.setAttribute(id, elements);


            lengthCount++;





            if (indexId != null) {


                pageContext.setAttribute(indexId, new Integer(getIndex()));


            }





            return (EVAL_BODY_AGAIN);


        } else {


            return (SKIP_BODY);


        }





    }





    /**


     * Clean up after processing this enumeration.


     * 


     * @exception JspException


     *                if a JSP exception has occurred


     */


    public int doEndTag() throws JspException {





        // Clean up our started state


        started = false;


        iterator = null;





        // Continue processing this page


        return (EVAL_PAGE);





    }





    /**


     * Release all allocated resources.


     */


    public void release() {





        super.release();





        iterator = null;


        lengthCount = 0;


        lengthValue = 0;


        offsetValue = 0;


        spaceValue = 0;





        id = null;


        collection = null;


        length = null;


        name = null;


        offset = null;


        property = null;


        scope = null;


        started = false;


        space = null;





    }


}