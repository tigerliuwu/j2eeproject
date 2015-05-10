/*
 * Created Mon Nov 27 23:58:44 CST 2006 by MyEclipse Hibernate Tool.
 */
package edu.pm.vo;

import java.io.Serializable;

/**
 * A class that represents a row in the 'products' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Products
    extends AbstractProducts
    implements Serializable
{
    /**
     * Simple constructor of Products instances.
     */
    public Products()
    {
    }

    /**
     * Constructor of Products instances given a simple primary key.
     * @param id
     */
    public Products(java.lang.Long id)
    {
        super(id);
    }

    /* Add customized code below */

}
